package com.lxl.vueblog.busin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxl.vueblog.busin.entity.Mlog;
import com.lxl.vueblog.busin.mapper.MlogMapper;
import com.lxl.vueblog.busin.service.IMlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IMlogServiceImpl extends ServiceImpl<MlogMapper, Mlog> implements IMlogService {
    @Autowired
    MlogMapper mlogMapper;
    @Override
    public Mlog queryById(Long id) {
        return mlogMapper.queryById(id);
    }

    @Override
    public Map<String, Object> queryMapById(Long id) {
        return mlogMapper.queryMapById(id);
    }

    @Override
    public List<Mlog> selectByOther(int i, int i1, int i2) {
        return mlogMapper.selectByOther(i,i1,i2);
    }

    @Override
    public IPage queryByPage(Page page, QueryWrapper wrappers) {
        return mlogMapper.queryByPage(page, wrappers);
    }
}
