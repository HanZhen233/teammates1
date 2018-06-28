package com.server.teammates1.service;
import com.server.teammates1.service.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class UerInfoService {
    public  static SecurityUser getUserDetails(){
       SecurityUser user=(SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return user;
    }
}
