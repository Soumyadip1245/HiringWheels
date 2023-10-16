package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("select u from User u where u.email = :email")
    public User findByEmail(@Param("email") String email);
    @Query("select u from User u where u.mobileNo = :mobileNo")
    public User findByphoneNumber(@Param("mobileNo") String mobileNo);
}
