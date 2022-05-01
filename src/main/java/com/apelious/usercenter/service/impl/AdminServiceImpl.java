package com.apelious.usercenter.service.impl;

import com.apelious.usercenter.domain.User;
import com.apelious.usercenter.mapper.UserMapper;
import com.apelious.usercenter.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apelious.usercenter.domain.Admin;
import com.apelious.usercenter.service.AdminService;
import com.apelious.usercenter.mapper.AdminMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author apelious
 * @description 针对表【admin(这个表描述后台管理员信息，虽然后台界面不打算更改了，但由于重构数据库和后端接口的改变，后台的后端模块还是要改一下)】的数据库操作Service实现
 * @createDate 2022-05-01 18:09:37
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {
    @Resource
    AdminMapper adminMapper;

    @Resource
    UserService userService;

    //盐值

    private static final String SALT_ONE = "415gsdca784";
    private static final String SALT_TWO = "742hakva";

    private static final String ADMIN_LOGIN_STATE = "adminLoginState";


    @Override
    public int adminRegister(String adminAccount, String adminPassword) {
        //帐号不能重复
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_account", adminAccount);
        int count = (int) this.count(queryWrapper);
        if (count > 0) {
            return -1;
        }

        //加密
        String digestedPassword = DigestUtils.md5DigestAsHex((SALT_ONE + adminPassword + SALT_TWO).getBytes());


        Admin admin = new Admin();
        admin.setAdminAccount(adminAccount);
        admin.setAdminPassword(digestedPassword);
        boolean saveResult = this.save(admin);
        if (!saveResult) {
            return -1;
        }
        return admin.getAdminId();

    }

    @Override
    public Admin adminLogin(String adminAccount, String adminPassword, HttpServletRequest request) {
        //加密
        String digestedPassword = DigestUtils.md5DigestAsHex((SALT_ONE + adminPassword + SALT_TWO).getBytes());

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_account", adminAccount);
        queryWrapper.eq("admin_password", digestedPassword);
        Admin admin = adminMapper.selectOne(queryWrapper);
        if (admin == null) {
            log.info("账户或密码错误");
            return null;
        }
        //脱敏
        Admin desensitizationAdmin = new Admin();
        desensitizationAdmin.setAdminId(admin.getAdminId());
        desensitizationAdmin.setAdminAccount(admin.getAdminAccount());
        desensitizationAdmin.setIsDelete(admin.getIsDelete());

        //记录用户登陆态
        request.getSession().setAttribute(ADMIN_LOGIN_STATE, desensitizationAdmin);

        return admin;
    }

    @Override
    public int adminLogout(HttpServletRequest request) {
        //移除登录态
        request.getSession().removeAttribute(ADMIN_LOGIN_STATE);
        return 1;
    }

    @Override
    public List<User> searchUsers(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like("user_name", username);
        }
        List<User> userList = userService.list(queryWrapper);
        List<User> list = userList.stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
        return list;
    }

    @Override
    public boolean deleteUser(int id, HttpServletRequest request) {
        if (id <= 0) {
            return false;
        }
        boolean b = userService.removeById(id);
        return true;
    }


}




