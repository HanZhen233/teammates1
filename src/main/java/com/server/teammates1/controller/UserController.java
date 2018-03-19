package com.server.teammates1.controller;

import com.server.teammates1.service.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class UserController {
    @RequestMapping(value = "/logined", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple() {

        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        SecurityUser user = (SecurityUser) auth.getPrincipal();
         String name =user.getUsername();
         if (name.equals(null)){
             return "没有取到";
         }
         else return  name;
    }
}

