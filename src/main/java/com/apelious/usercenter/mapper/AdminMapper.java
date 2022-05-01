package com.apelious.usercenter.mapper;

import com.apelious.usercenter.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author apelious
* @description 针对表【admin(这个表描述后台管理员信息，虽然后台界面不打算更改了，但由于重构数据库和后端接口的改变，后台的后端模块还是要改一下)】的数据库操作Mapper
* @createDate 2022-05-01 18:09:37
* @Entity com.apelious.usercenter.domain.Admin
*/
public interface AdminMapper extends BaseMapper<Admin> {

}




