package org.ncu.hirewheels.service.userService;
import org.ncu.hirewheels.entity.*;
import org.ncu.hirewheels.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public User createUser(User user) {
        Role role = roleRepository.findByRoleName(user.getRole().getRoleName()); 
        if (role == null) {
            roleRepository.save(role);
        }
        user.setRole(role); 
        return userRepository.save(user);
    }
    @Override
    public User getUserByEmail(String email) {
        User userData = userRepository.findByEmail(email);
        return userData;
    }

   


   
   


}
