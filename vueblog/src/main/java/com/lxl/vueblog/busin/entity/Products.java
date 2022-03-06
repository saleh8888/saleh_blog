package com.lxl.vueblog.busin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("goods")
@Data
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private int productId;
    private String productName;
    private String brand;
    private int productNumber;
    private String productType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date productDate;

}
