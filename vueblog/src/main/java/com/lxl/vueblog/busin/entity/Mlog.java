package com.lxl.vueblog.busin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("m_log")
@Data
public class Mlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private int id;
    private String userName;
    private Date logTime;
    private int operationStatus;
    private String blogTitle;
    private int operationType;
//    @TableField(exist = false)
//    private String description;

    public Mlog() {
    }

    public Mlog(String userName, Date logTime, int operationStatus, String blogTitle, int operationType) {
        this.userName = userName;
        this.logTime = logTime;
        this.operationStatus = operationStatus;
        this.blogTitle = blogTitle;
        this.operationType = operationType;
    }
}
