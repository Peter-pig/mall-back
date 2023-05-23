package com.example.mallusers.controller;

import com.example.mallcommon.common.R;
import com.example.mallcommon.entity.TbUser;
import com.example.mallusers.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;
    @PostMapping("signIn")
    public R signIn(@RequestBody TbUser tbUser){
        return userService.signIn(tbUser);
    }
    @PostMapping("register")
    public R register(@RequestBody TbUser tbUser){
       return userService.register(tbUser);
    }
}
