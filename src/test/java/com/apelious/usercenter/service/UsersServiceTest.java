package com.apelious.usercenter.service;
import java.util.Date;

import com.apelious.usercenter.domain.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 用户测试 a test
 * @author apelious
 */
@SpringBootTest
public class UsersServiceTest {

    @Resource
    private UsersService usersService;

    @Test
    public void testAddUser(){
        Users users = new Users();
        users.setUserAccount("dcx772204");
        users.setUserName("dcx");
        users.setUserPassword("1232465");
        users.setUserGender(0);
        users.setPhoneNumber("");
        users.setEmail("");
        users.setUserIntroduction("");
        users.setLocation("");
        users.setAvatar("");
        boolean result = usersService.save(users);
        System.out.println(users.getUserId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "Apelious";
        String userPassword = "13719561029Cx";
        String checkPassword = "13719561029Cx";
        String userName = "canxian";
        int result = usersService.userRegister(userAccount, userPassword, checkPassword, userName);
        System.out.println("result = "+result);
    }
}