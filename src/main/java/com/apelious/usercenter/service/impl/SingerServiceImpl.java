package com.apelious.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apelious.usercenter.domain.Singer;
import com.apelious.usercenter.service.SingerService;
import com.apelious.usercenter.mapper.SingerMapper;
import org.springframework.stereotype.Service;

/**
* @author apelious
* @description 针对表【singer(这个表描述歌手信息)】的数据库操作Service实现
* @createDate 2022-05-02 20:35:02
*/
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer>
    implements SingerService{

}




