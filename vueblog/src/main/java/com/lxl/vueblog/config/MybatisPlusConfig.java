package com.lxl.vueblog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.lxl.vueblog.busin.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInnerInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return  paginationInterceptor;
    }

}