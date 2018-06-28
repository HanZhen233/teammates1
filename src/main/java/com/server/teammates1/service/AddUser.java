package com.server.teammates1.service;

import com.server.teammates1.entity.Role;
import com.server.teammates1.entity.User;
import com.server.teammates1.repository.RoleRepository;
import com.server.teammates1.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;


public class AddUser {
@Autowired
    SysUserRepository sysUserRepository;
@Autowired
    RoleRepository roleRepository;

    public AddUser(String name,String password,String email,String mobilePhone){
        User user=new User();
    user.setName(name);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(mobilePhone);
    Role role=roleRepository.findById(2);
         List<Role> roles= new ArrayList<>();
         roles.add(role);
         user.setRoles(roles);
         sysUserRepository.save(user);
     }


}
