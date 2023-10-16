package org.ncu.hirewheels.service.userService;


import org.ncu.hirewheels.entity.*;

public interface UserService {
    User createUser(User user);
    User getUserByEmail(String email);
}
