package com.apelious.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apelious.usercenter.domain.Users;
import com.apelious.usercenter.service.UsersService;
import com.apelious.usercenter.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author apelious
* @description 针对表【users(这个表描述用户信息)】的数据库操作Service实现
* @createDate 2022-04-29 20:20:11
*/
@Service
@Slf4j
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    //盐值

    private static final String SALT_ONE = "415gsdca784";
    private static final String SALT_TWO= "742hakva";

    private static final String USER_LOGIN_STATE = "userLoginState";

    @Override
    public int userRegister(String userAccount, String userPassword, String checkPassword, String userName) {
        //密码和校验密码相同
        if (!userPassword.equals(checkPassword)){
            return -4;
        }

        //帐户不能包含特殊字符-帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
        String validAccount = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
        Matcher matcher = Pattern.compile(validAccount).matcher(userAccount);
        if(!matcher.find()){
            return -5;
        }

        //对于密码的限制-强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-16之间)
        String validPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
        Matcher matcher1 = Pattern.compile(validPassword).matcher(userPassword);
        if (!matcher1.find()){
            return -6;
        }

        //帐号不能重复
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", userAccount);
        long count = this.count(queryWrapper);
        if(count > 0){
            return -7;
        }

        //加密
        String digestedPassword = DigestUtils.md5DigestAsHex((SALT_ONE+userPassword+SALT_TWO).getBytes());

        //插入数据
        Users users = new Users();
        users.setUserName(userName);
        users.setUserAccount(userAccount);
        users.setUserPassword(digestedPassword);
        boolean saveResult = this.save(users);
        if (!saveResult){
            return -8;
        }

        return users.getUserId();

    }

    @Override
    public Users userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //帐户不能包含特殊字符-帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
        String validAccount = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
        Matcher matcher = Pattern.compile(validAccount).matcher(userAccount);
        if(!matcher.find()){
            return null;
        }

        //对于密码的限制-强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-16之间)
        String validPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$";
        Matcher matcher1 = Pattern.compile(validPassword).matcher(userPassword);
        if (!matcher1.find()){
            return null;
        }

        //加密
        String digestedPassword = DigestUtils.md5DigestAsHex((SALT_ONE+userPassword+SALT_TWO).getBytes());

        //查询用户是否存在
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", userAccount);
        queryWrapper.eq("user_password", digestedPassword);
        Users users = usersMapper.selectOne(queryWrapper);
        if (users == null){
            //账号或密码错误
            log.info("user login failed, Because the account or password is entered incorrectly");
            return null;
        }

        //用户脱敏
        Users desensitizationUser = new Users();
        desensitizationUser.setUserId(users.getUserId());
        desensitizationUser.setUserAccount(users.getUserAccount());
        desensitizationUser.setUserName(users.getUserName());
        desensitizationUser.setUserGender(users.getUserGender());
        desensitizationUser.setPhoneNumber(users.getPhoneNumber());
        desensitizationUser.setEmail(users.getEmail());
        desensitizationUser.setBirthday(users.getBirthday());
        desensitizationUser.setUserIntroduction(users.getUserIntroduction());
        desensitizationUser.setLocation(users.getLocation());
        desensitizationUser.setAvatar(users.getAvatar());
        desensitizationUser.setCreateTime(users.getCreateTime());

        //记录用户登陆态
        request.getSession().setAttribute(USER_LOGIN_STATE, desensitizationUser);

        return desensitizationUser;
    }
}




