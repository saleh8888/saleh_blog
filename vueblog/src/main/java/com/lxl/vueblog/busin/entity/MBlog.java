package com.lxl.vueblog.busin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author Saleh
 * @since 2022-02-23
 */
@TableName("m_blog")
@Data
@ApiModel(value = "MBlog对象", description = "")
public class MBlog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String title;

    private String description;

    private String content;

    private Date created;

    private Integer status;

    @TableField(exist = false)
    List<Mlog> logs;

    @Override
    public String toString() {
        return "MBlog{" +
            "id=" + id +
            ", userId=" + userId +
            ", title=" + title +
            ", description=" + description +
            ", content=" + content +
            ", created=" + created +
            ", status=" + status +
        "}";
    }
}
