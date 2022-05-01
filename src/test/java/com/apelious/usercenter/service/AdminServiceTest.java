package com.apelious.usercenter.service;

import com.apelious.usercenter.domain.Admin;
import com.apelious.usercenter.domain.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lenovo
 * @create 2022/5/1 20:00
 */
@SpringBootTest
public class AdminServiceTest {

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    @Test
    public void testAdminRegister() {
        String adminAccount = "cyc";
        String adminPassword = "111222333";
        int result = adminService.adminRegister(adminAccount, adminPassword);
        System.out.println(result);
    }

    @Test
    public void testAdminLogin() {
        String adminAccount = "cyc";
        String adminPassword = "111222333";
//        Admin admin = adminService.adminLogin(adminAccount, adminPassword, request);
//        System.out.println(admin);
    }

    @Test
    public void testDeleteUser() {
        boolean result = userService.removeById(1L);
        System.out.println(result);
    }

    @Test
    public void testGetUser() {
        String name = "can";
//        List<User>userList= adminService.searchUsers(name);
//        System.out.println(userList.size());
    }
}
