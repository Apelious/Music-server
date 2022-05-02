package com.apelious.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apelious.usercenter.domain.Mapss;
import com.apelious.usercenter.service.MapssService;
import com.apelious.usercenter.mapper.MapssMapper;
import org.springframework.stereotype.Service;

/**
* @author apelious
* @description 针对表【mapss(这个表描述歌手与歌曲的映射)】的数据库操作Service实现
* @createDate 2022-05-02 20:35:24
*/
@Service
public class MapssServiceImpl extends ServiceImpl<MapssMapper, Mapss>
    implements MapssService{

}




