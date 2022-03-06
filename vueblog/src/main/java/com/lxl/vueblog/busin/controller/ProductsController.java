package com.lxl.vueblog.busin.controller;

import cn.hutool.core.date.DateTime;
import com.lxl.vueblog.busin.dto.ProductRequest;
import com.lxl.vueblog.busin.entity.Products;
import com.lxl.vueblog.busin.service.OrderService;
import com.lxl.vueblog.busin.service.ProductsService;
import com.lxl.vueblog.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;
    @Autowired
    OrderService orderService;

    @PostMapping("/products")
     public boolean addProduct(@RequestBody ProductRequest  productRequest){

         boolean isTrue = false;
         Products products = new Products();
         products.setProductName(productRequest.getProductName());
         products.setBrand(productRequest.getBrand());
         products.setProductNumber(productRequest.getProductNumber());

         products.setProductDate(DateTime.of(productRequest.getProductDate(), "yyyy-MM-dd HH:mm:ss"));
         //products.setProductDate(new DateTime());
         return productsService.save(products);


     }
     @GetMapping("/products/{id}")
    public Result getProductsById(@PathVariable("id") int id){
        Products products = productsService.getById(id);
        if (null == products) {
            return Result.fail("查无数据");
        }
        return Result.success(products);
    }






/*    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat2.format(new Date()));
        try {
            Date d = simpleDateFormat2.parse("2020-03-04");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

}
