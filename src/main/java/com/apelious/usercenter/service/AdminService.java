package com.apelious.usercenter.service;

import com.apelious.usercenter.domain.Admin;
import com.apelious.usercenter.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author apelious
 * @description 针对表【admin(这个表描述后台管理员信息，虽然后台界面不打算更改了，但由于重构数据库和后端接口的改变，后台的后端模块还是要改一下)】的数据库操作Service
 * @createDate 2022-05-01 18:09:37
 */
public interface AdminService extends IService<Admin> {
    /**
     * 管理员注册
     *
     * @param adminAccount  管理员账户
     * @param adminPassword 管理员密码
     * @return 管理员id
     */
    int adminRegister(String adminAccount, String adminPassword);

    /**
     * 管理员登录
     *
     * @param adminAccount  管理员账户
     * @param adminPassword 管理员密码
     * @return 脱敏后的管理员信息
     */
    Admin adminLogin(String adminAccount, String adminPassword, HttpServletRequest request);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int adminLogout(HttpServletRequest request);

    List<User> searchUsers(String username);


    boolean deleteUser(@RequestBody int id, HttpServletRequest request);

}
