package com.lxl.vueblog.busin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxl.vueblog.common.Result;
import com.lxl.vueblog.busin.entity.MBlog;
import com.lxl.vueblog.busin.entity.Mlog;
import com.lxl.vueblog.busin.service.IMBlogService;
import com.lxl.vueblog.busin.service.IMlogService;
import com.lxl.vueblog.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Saleh
 * @since 2022-02-23
 */
@RestController
public class MBlogController {
    @Autowired
    IMBlogService imBlogService;
    @Autowired
    IMlogService mlogService;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = imBlogService.page(page, new QueryWrapper<MBlog>().orderByDesc("created"));
        List<MBlog> aa = pageData.getRecords();
        for (MBlog blog : aa) {
            System.out.println("@@@:" + blog.getTitle());
            QueryWrapper wrappers = new QueryWrapper<Mlog>();
            wrappers.eq("blog_title",blog.getTitle());
//            List<Mlog> logs = mlogService.list(wrappers);
//            List<Mlog> logs = mlogService.selectByOther(1,2,3);
            Page logPage = new Page(1, 1);
            IPage logs = mlogService.queryByPage(logPage, wrappers);
            blog.setLogs(logs.getRecords());
        }
        return Result.success(pageData);
    }

    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        MBlog blog = imBlogService.getById(id);
        Assert.notNull(blog, "该博客已删除");
        return Result.success(blog);
    }
/*
    *
         * 新增|编辑
         *
         * @param blog
         * @return*/

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody MBlog blog) {
        MBlog temp = null;
        if (blog.getId() != null) { //编辑
            temp = imBlogService.getById(blog.getId());
            System.out.println(ShiroUtil.getProfile());
//            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(), "没有编辑权限！");
        } else { //新增
            temp = new MBlog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(new Date());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        boolean opSt = imBlogService.saveOrUpdate(temp);
        if (opSt) {
            //日志记录
            Mlog editLog;
            //String userName, Date logTime, int operationStatus, String blogTitle, int operationType
            if (blog.getId() != null) {
                //编辑日志
                editLog = new Mlog("admin", new Date(), 1, blog.getTitle(), 2);
            } else {
                //新增日志
                editLog = new Mlog("admin", new Date(), 1, blog.getTitle(), 1);
            }
            mlogService.save(editLog);
        }
        return Result.success(blog);
    }
/*
*
 * 删除
 *
 * @param id
 * @return*/


    @DeleteMapping("/blog/{id}")
    public boolean del(@PathVariable(name = "id") Long id) {
        boolean opSt = false;
        opSt = imBlogService.removeById(id);
        if (opSt) {
            //插入删除日志记录
        }
        return imBlogService.removeById(id);
    }


}
