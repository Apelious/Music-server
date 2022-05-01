package com.apelious.usercenter.controller;

import com.apelious.usercenter.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  用户接口
 *
 * @author apelious
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UserService userService;

//    @PostMapping("/regester")
//    public int userRegester(){
//        usersService.userRegister()
//    }
}
