package com.apelious.usercenter.service;

import com.apelious.usercenter.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author apelious
* @description 针对表【users(这个表描述用户信息)】的数据库操作Service
* @createDate 2022-04-29 20:20:11
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param userAccount 用户帐户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @param userName 用户名字
     * @return 新用户ID
     */
    int userRegister(String userAccount, String userPassword, String checkPassword, String userName);

    /**
     * 用户登陆
     * @param userAccount 用户帐户
     * @param userPassword 用户密码
     * @param request request
     * @return 用户数据
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);
    /**
     * 用户脱敏
     *
     * @param originUser 原本的数据
     * @return 脱敏后的数据
     */
    User getSafetyUser(User originUser);
}
