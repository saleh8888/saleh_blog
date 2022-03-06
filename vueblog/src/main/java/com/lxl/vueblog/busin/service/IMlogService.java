package com.lxl.vueblog.busin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxl.vueblog.busin.entity.Mlog;

import java.util.List;
import java.util.Map;


public interface IMlogService extends IService<Mlog> {
    Mlog queryById(Long id);
    Map<String, Object> queryMapById(Long id);

    List<Mlog> selectByOther(int i, int i1, int i2);

    IPage queryByPage(Page page, QueryWrapper wrappers);
}
