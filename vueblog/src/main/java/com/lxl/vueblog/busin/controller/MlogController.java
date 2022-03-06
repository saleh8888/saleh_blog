package com.lxl.vueblog.busin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxl.vueblog.common.Result;
import com.lxl.vueblog.busin.entity.Mlog;
import com.lxl.vueblog.busin.service.IMlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MlogController {
   @Autowired
   IMlogService iMlogService;

   @GetMapping("/logs")
   public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
      Page page = new Page(currentPage, 5);
      IPage pageData = iMlogService.page(page, new QueryWrapper<Mlog>());

      return Result.success(pageData);
   }


   @GetMapping("/log/{id}")
   public Result detail(@PathVariable(name = "id") Long id) {
//      Mlog log = iMlogService.getById(id);
//      Mlog log = iMlogService.queryById(id);
      Map<String, Object> mm = iMlogService.queryMapById(id);
      for (Map.Entry<String, Object> m : mm.entrySet()) {
         System.out.println(m.getKey() + " ------> " + m.getValue());
      }
      return Result.success(mm);
   }

   @PostMapping("/log")
   public boolean addLog(@RequestBody Mlog mlog){
      return iMlogService.save(mlog);
   }









}
