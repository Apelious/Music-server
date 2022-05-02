package com.apelious.usercenter.controller;

<<<<<<< HEAD:src/main/java/com/apelious/usercenter/controller/UsersController.java
import com.apelious.usercenter.domain.request.UsersRegisterRequest;
import com.apelious.usercenter.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
=======
import com.apelious.usercenter.service.UserService;
>>>>>>> orign/cyc:src/main/java/com/apelious/usercenter/controller/UserController.java
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
public class UserController {

    @Resource
<<<<<<< HEAD:src/main/java/com/apelious/usercenter/controller/UsersController.java
    private UsersService usersService;

    @PostMapping("/register")
    public int userRegister(@RequestBody UsersRegisterRequest usersRegisterRequest){
        if(usersRegisterRequest == null){
            return -1;
        }
        String userAccount = usersRegisterRequest.getUserAccount();
        String userPassword = usersRegisterRequest.getUserPassword();
        String checkPassword = usersRegisterRequest.getCheckPassword();
        String userName = usersRegisterRequest.getUserName();
        return usersService.userRegister(userAccount,userPassword,checkPassword,userName);
    }
=======
    private UserService userService;
//
//    @PostMapping("/regester")
//    public int userRegester(){
//        userService.userRegister()
//    }
>>>>>>> orign/cyc:src/main/java/com/apelious/usercenter/controller/UserController.java
}
