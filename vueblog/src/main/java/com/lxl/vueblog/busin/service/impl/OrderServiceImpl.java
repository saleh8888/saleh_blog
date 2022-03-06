package com.lxl.vueblog.busin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxl.vueblog.busin.entity.Order;
import com.lxl.vueblog.busin.mapper.OrderMapper;
import com.lxl.vueblog.busin.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {


}
