package com.lxl.vueblog.busin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxl.vueblog.busin.entity.Products;
import com.lxl.vueblog.busin.mapper.ProductsMapper;
import com.lxl.vueblog.busin.service.ProductsService;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {
}
