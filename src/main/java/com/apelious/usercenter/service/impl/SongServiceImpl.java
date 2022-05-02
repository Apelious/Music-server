package com.apelious.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apelious.usercenter.domain.Song;
import com.apelious.usercenter.service.SongService;
import com.apelious.usercenter.mapper.SongMapper;
import org.springframework.stereotype.Service;

/**
* @author apelious
* @description 针对表【song(这个表描述歌曲信息)】的数据库操作Service实现
* @createDate 2022-05-02 20:35:15
*/
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song>
    implements SongService{

}




