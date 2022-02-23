package com.lxl.vueblog.service.impl;

import com.lxl.vueblog.system.entity.MUser;
import com.lxl.vueblog.system.mapper.MUserMapper;
import com.lxl.vueblog.system.service.IMUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Saleh
 * @since 2022-02-23
 */
@Service
public class MUserServiceImpl extends ServiceImpl<MUserMapper, MUser> implements IMUserService {

}
