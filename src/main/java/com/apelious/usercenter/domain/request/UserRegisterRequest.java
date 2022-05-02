package com.apelious.usercenter.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author apelious
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 5653259821782946237L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String userName;

}
