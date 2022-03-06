package com.lxl.vueblog.busin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxl.vueblog.busin.entity.Mlog;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MlogMapper extends BaseMapper<Mlog> {

    Mlog queryById(Long id);

    Map<String, Object> queryMapById(Long id);

    List<Mlog> selectByOther(int i, int i1, int i2);

    IPage queryByPage(Page page, QueryWrapper wrappers);
}
