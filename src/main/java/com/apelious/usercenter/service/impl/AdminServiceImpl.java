package com.apelious.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apelious.usercenter.domain.Admin;
import com.apelious.usercenter.service.AdminService;
import com.apelious.usercenter.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author apelious
* @description 针对表【admin(这个表描述后台管理员信息，虽然后台界面不打算更改了，但由于重构数据库和后端接口的改变，后台的后端模块还是要改一下)】的数据库操作Service实现
* @createDate 2022-05-01 18:09:37
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




