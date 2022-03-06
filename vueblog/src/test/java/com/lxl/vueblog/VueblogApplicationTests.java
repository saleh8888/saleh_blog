package com.lxl.vueblog;

import com.lxl.vueblog.busin.service.IMBlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VueblogApplicationTests {
    @Autowired
    IMBlogService imBlogService;
    @Test
    void contextLoads() {
        imBlogService.removeById(6);
    }

}
