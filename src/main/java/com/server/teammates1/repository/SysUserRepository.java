package com.server.teammates1.repository;

import com.server.teammates1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<User,Integer>{
    public User findByName(String name);
}
