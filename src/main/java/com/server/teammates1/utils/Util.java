package com.server.teammates1.utils;
import com.server.teammates1.service.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class Util {
    public  static SecurityUser getUserDetails(){
       SecurityUser user=(SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return user;
    }
}
