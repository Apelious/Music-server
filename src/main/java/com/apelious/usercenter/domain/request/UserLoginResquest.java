package com.apelious.usercenter.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author apelious
 */
@Data
public class UserLoginResquest implements Serializable {

    private static final long serialVersionUID = -7316155678923780907L;

    private String userAccount;

    private String userPassword;
}
