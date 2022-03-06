package com.lxl.vueblog.busin.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private int productsId;
    private String productName;
    private String brand;
    private int productNumber;
    private String productType;
    private String productDate;
}
