package com.apelious.usercenter.service;

import com.apelious.usercenter.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 用户测试 a test
 * @author apelious
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;



    @Test
    public void testAddUser(){
        User user = new User();
        user.setUserAccount("dcx772204");
        user.setUserName("dcx");
        user.setUserPassword("1232465");
        user.setUserGender(0);
        user.setPhoneNumber("");
        user.setEmail("");
        user.setUserIntroduction("");
        user.setLocation("");
        user.setAvatar("");
        boolean result = userService.save(user);
        System.out.println(user.getUserId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "Apelious";
        String userPassword = "13719561029Cx";
        String checkPassword = "13719561029Cx";
        String userName = "canxian";
        int result = userService.userRegister(userAccount, userPassword, checkPassword, userName);
        System.out.println("result = "+result);
    }

}