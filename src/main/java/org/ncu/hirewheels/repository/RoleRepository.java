package org.ncu.hirewheels.repository;

import org.ncu.hirewheels.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("select r from Role r where r.roleName = :roleName")
    Role findByRoleName(String roleName);
}
