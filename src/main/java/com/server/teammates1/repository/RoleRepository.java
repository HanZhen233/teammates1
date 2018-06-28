package com.server.teammates1.repository;


import com.server.teammates1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
public Role findByName(String name);
public  Role findById(long id);
}
