package com.apelious.usercenter.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 一张专辑应该有一张对应的专辑图片
 * @TableName map_saa
 */
@TableName(value ="map_saa")
@Data
public class MapSaa implements Serializable {
    /**
     * 每个歌手的唯一标识符
     */
    @TableId
    private Integer singerId;

    /**
     * 专辑名称
     */
    @TableId
    private String album;

    /**
     * 专辑图片索引位置
     */
    private String albumPicture;

    /**
     * 是否为用户上传
     */
    private Integer isUpload;

    /**
     * 数据是否被弃用
     */
    private Integer isDelete;

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
        MapSaa other = (MapSaa) that;
        return (this.getSingerId() == null ? other.getSingerId() == null : this.getSingerId().equals(other.getSingerId()))
            && (this.getAlbum() == null ? other.getAlbum() == null : this.getAlbum().equals(other.getAlbum()))
            && (this.getAlbumPicture() == null ? other.getAlbumPicture() == null : this.getAlbumPicture().equals(other.getAlbumPicture()))
            && (this.getIsUpload() == null ? other.getIsUpload() == null : this.getIsUpload().equals(other.getIsUpload()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSingerId() == null) ? 0 : getSingerId().hashCode());
        result = prime * result + ((getAlbum() == null) ? 0 : getAlbum().hashCode());
        result = prime * result + ((getAlbumPicture() == null) ? 0 : getAlbumPicture().hashCode());
        result = prime * result + ((getIsUpload() == null) ? 0 : getIsUpload().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", singerId=").append(singerId);
        sb.append(", album=").append(album);
        sb.append(", albumPicture=").append(albumPicture);
        sb.append(", isUpload=").append(isUpload);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}