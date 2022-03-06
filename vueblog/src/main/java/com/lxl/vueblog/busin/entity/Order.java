package com.lxl.vueblog.busin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("order")
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private int   orderId;
    private String goodsName;
    private int goodsNumber;
    private String goodsBrand;
    private String goodsType;






}
