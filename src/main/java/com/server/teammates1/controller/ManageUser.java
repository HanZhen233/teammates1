package com.server.teammates1.controller;

import com.server.teammates1.entity.Role;
import com.server.teammates1.entity.User;
import com.server.teammates1.repository.RoleRepository;
import com.server.teammates1.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/manage/manageUser")
public class ManageUser {
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private RoleRepository roleRepository;
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)/*注册*/
    public String addUername(@RequestParam("username")String username, @RequestParam("password")String password
            , @RequestParam("mail")String mail, @RequestParam("phone") String phone
//                          ,@RequestParam("sex")String sex, @RequestParam("school")String school,
//                          @RequestParam("major")String major
    ){

           if(sysUserRepository.findByName(username)!=null)
            return "用户已经存在";
        password= new BCryptPasswordEncoder().encode(password);
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(mail);
        user.setPhone(phone);
        Role role=roleRepository.findById(1);
        List<Role> roles= new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        sysUserRepository.save(user);

//           AddUser addUser=new AddUser(username,password,mail,phone);
        return "添加成功";
    }


}
