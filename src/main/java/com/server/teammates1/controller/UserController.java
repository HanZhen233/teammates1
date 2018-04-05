package com.server.teammates1.controller;


import com.server.teammates1.entity.Role;
import com.server.teammates1.entity.User;
import com.server.teammates1.repository.RoleRepository;
import com.server.teammates1.repository.SysUserRepository;
import com.server.teammates1.service.AddUser;
import com.server.teammates1.service.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/logined")/*返回个人信息*/
    public  SecurityUser  hello(){
        String authority=null;
        String  username=null;
        SecurityUser securityUser=null;
        Object principal =  SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
             securityUser   =((SecurityUser)principal);

            }
        return    securityUser;
    }

        @RequestMapping(value = "/addUser",method = RequestMethod.POST)/*注册*/
       public String addUername(@RequestParam("username")String username,@RequestParam("password")String password
       ,                   @RequestParam("mail")String mail, @RequestParam("phone") String phone
//                          ,@RequestParam("sex")String sex, @RequestParam("school")String school,
//                          @RequestParam("major")String major
                             ){


            password= new BCryptPasswordEncoder().encode(password);
            User user=new User();
            user.setName(username);
            user.setPassword(password);
            user.setEmail(mail);
            user.setMobilePhone(phone);
            Role role=roleRepository.findById(2);
            List<Role> roles= new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
            sysUserRepository.save(user);

//           AddUser addUser=new AddUser(username,password,mail,phone);


        return "添加成功";
        }

        @RequestMapping(value = "/logout")
    public String logout(){

    return "登出";
    }


}

