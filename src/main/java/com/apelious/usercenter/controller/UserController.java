package com.apelious.usercenter.controller;


import com.apelious.usercenter.domain.User;
import com.apelious.usercenter.domain.request.UserLoginResquest;
import com.apelious.usercenter.domain.request.UserRegisterRequest;
import com.apelious.usercenter.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  用户接口
 *
 * @author apelious
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public int userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if(userRegisterRequest == null){
            return -1;
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String userName = userRegisterRequest.getUserName();
        return userService.userRegister(userAccount,userPassword,checkPassword,userName);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginResquest userLoginResquest, HttpServletRequest request){
        if(userLoginResquest == null){
            return null;
        }
        String userAccount = userLoginResquest.getUserAccount();
        String userPassword = userLoginResquest.getUserPassword();
        return userService.userLogin(userAccount, userPassword, request);
    }

    @PostMapping("/search")
    public List<User> searchUsers(String userName){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(userName)){
            queryWrapper.like("suer_name", userName);
        }
        return userService.list(queryWrapper);
    }
}
