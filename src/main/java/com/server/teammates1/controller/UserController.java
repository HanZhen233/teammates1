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
  @RequestMapping(value = "login1")
  public  String login(){
      return "登录成功";
  }

    @RequestMapping(value = "/logined")/*返回个人信息*/
    public  User  hello(){

        SecurityUser securityUser=null;
        Object principal =  SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
             securityUser   =((SecurityUser)principal);
            }
            User user=new User();
        user.setName(securityUser.getUsername());
        user.setMajor(securityUser.getMajor());
        user.setSex(securityUser.getSex());
        user.setUniversity(securityUser.getUniversity());
        user.setQq(securityUser.getQq());
        user.setEmail(securityUser.getEmail());
        user.setTechnology(securityUser.getTechnology());
        user.setPhone(securityUser.getPhone());

        return    user;


    }

        @RequestMapping(value = "/addUser",method = RequestMethod.POST)/*注册*/
       public String addUername(@RequestParam("username")String username,@RequestParam("password")String password
       ,                   @RequestParam("mail")String mail, @RequestParam("phone") String phone,
                        @RequestParam("qq")String qq, @RequestParam("sex")String sex, @RequestParam("university")String university,
                          @RequestParam("major")String major,
                          @RequestParam("technology")String technology
                             ){
//            private String qq;
//            private String sex;
//            private String university;
//            private String technology;
            if(sysUserRepository.findByName(username)!=null)
                return "用户已经存在";
            password= new BCryptPasswordEncoder().encode(password);
            User user=new User();
            user.setName(username);
            user.setPassword(password);
            user.setEmail(mail);
            user.setPhone(phone);
            user.setQq(qq);
            user.setSex(sex);
            user.setUniversity(university);
            user.setMajor(major);
            user.setTechnology(technology);


            Role role=roleRepository.findById(2);
            List<Role> roles= new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
            sysUserRepository.save(user);

//           AddUser addUser=new AddUser(username,password,mail,phone);
        return "添加成功";
        }


    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)/*注册*/
    public String changePassword(@RequestParam("password")String password)throws Exception{
        String authority=null;
        String  username=null;
        SecurityUser securityUser=null;
        Object principal =  SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            securityUser   =((SecurityUser)principal);
        }
     username=securityUser.getUsername();
        password= new BCryptPasswordEncoder().encode(password);
        User user= sysUserRepository.findByName(username);
        user.setPassword(password);
     sysUserRepository.saveAndFlush(user);
        return "修改成功";
    }







    @RequestMapping(value = "/logout")
    public String logout(){

    return "登出";
    }


}

