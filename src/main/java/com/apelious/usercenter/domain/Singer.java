package com.apelious.usercenter.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 这个表描述歌手信息
 * @TableName singer
 */
@TableName(value ="singer")
@Data
public class Singer implements Serializable {
    /**
     * 每个歌手的唯一标识符
     */
    @TableId(type = IdType.AUTO)
    private Integer singerId;

    /**
     * 歌手名字
     */
    private String singerName;

    /**
     * 歌手性别
     */
    private Integer singerGender;

    /**
     * 歌手国籍
     */
    private String country;

    /**
     * 歌手简介
     */
    private String singerIntroduction;

    /**
     * 歌手图片
     */
    private String photoUrl;

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
        Singer other = (Singer) that;
        return (this.getSingerId() == null ? other.getSingerId() == null : this.getSingerId().equals(other.getSingerId()))
            && (this.getSingerName() == null ? other.getSingerName() == null : this.getSingerName().equals(other.getSingerName()))
            && (this.getSingerGender() == null ? other.getSingerGender() == null : this.getSingerGender().equals(other.getSingerGender()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getSingerIntroduction() == null ? other.getSingerIntroduction() == null : this.getSingerIntroduction().equals(other.getSingerIntroduction()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getIsUpload() == null ? other.getIsUpload() == null : this.getIsUpload().equals(other.getIsUpload()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSingerId() == null) ? 0 : getSingerId().hashCode());
        result = prime * result + ((getSingerName() == null) ? 0 : getSingerName().hashCode());
        result = prime * result + ((getSingerGender() == null) ? 0 : getSingerGender().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getSingerIntroduction() == null) ? 0 : getSingerIntroduction().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
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
        sb.append(", singerId=").append(singerId);
        sb.append(", singerName=").append(singerName);
        sb.append(", singerGender=").append(singerGender);
        sb.append(", country=").append(country);
        sb.append(", singerIntroduction=").append(singerIntroduction);
        sb.append(", photoUrl=").append(photoUrl);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isUpload=").append(isUpload);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}