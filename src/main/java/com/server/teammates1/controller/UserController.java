package com.server.teammates1.controller;

import com.server.teammates1.entity.User;
import com.server.teammates1.repository.SysUserRepository;
import com.server.teammates1.service.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Security;
import java.util.Iterator;


@RestController
public class UserController {
    @Autowired
    private SysUserRepository sysUserRepository;
    @RequestMapping(value = "/logined")

    public  SecurityUser  hello(){
        String authority=null;
        String  username=null;
        SecurityUser securityUser=null;
        Object principal =  SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
             securityUser   =((SecurityUser)principal);

            }
        return    securityUser; }

    public void currentUserNameSimple() {


    }
}

