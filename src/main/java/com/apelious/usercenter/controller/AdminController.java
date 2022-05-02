package com.apelious.usercenter.controller;

import com.apelious.usercenter.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员控制
 *
 * @author wangyi
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

}
