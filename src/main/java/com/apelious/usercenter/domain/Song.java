package com.apelious.usercenter.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 这个表描述歌曲信息
 * @TableName song
 */
@TableName(value ="song")
@Data
public class Song implements Serializable {
    /**
     * 每首歌的唯一标识符
     */
    @TableId(type = IdType.AUTO)
    private Integer songId;

    /**
     * 歌曲名字
     */
    private String songName;

    /**
     * 歌曲的歌词文件索引位置
     */
    private String lrcUrl;

    /**
     * 歌曲所属于的专辑
     */
    private String album;

    /**
     * 歌曲发行时间
     */
    private Date releaseTime;

    /**
     * 歌曲风格标签
     */
    private Integer songTag;

    /**
     * 数据是否被弃用
     */
    private Integer isDelete;

    /**
     * 是否为用户上传
     */
    private Integer isUpload;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Song other = (Song) that;
        return (this.getSongId() == null ? other.getSongId() == null : this.getSongId().equals(other.getSongId()))
            && (this.getSongName() == null ? other.getSongName() == null : this.getSongName().equals(other.getSongName()))
            && (this.getLrcUrl() == null ? other.getLrcUrl() == null : this.getLrcUrl().equals(other.getLrcUrl()))
            && (this.getAlbum() == null ? other.getAlbum() == null : this.getAlbum().equals(other.getAlbum()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getSongTag() == null ? other.getSongTag() == null : this.getSongTag().equals(other.getSongTag()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsUpload() == null ? other.getIsUpload() == null : this.getIsUpload().equals(other.getIsUpload()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSongId() == null) ? 0 : getSongId().hashCode());
        result = prime * result + ((getSongName() == null) ? 0 : getSongName().hashCode());
        result = prime * result + ((getLrcUrl() == null) ? 0 : getLrcUrl().hashCode());
        result = prime * result + ((getAlbum() == null) ? 0 : getAlbum().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getSongTag() == null) ? 0 : getSongTag().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getIsUpload() == null) ? 0 : getIsUpload().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", songId=").append(songId);
        sb.append(", songName=").append(songName);
        sb.append(", lrcUrl=").append(lrcUrl);
        sb.append(", album=").append(album);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", songTag=").append(songTag);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isUpload=").append(isUpload);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}