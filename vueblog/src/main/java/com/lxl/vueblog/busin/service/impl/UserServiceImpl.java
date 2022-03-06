package com.lxl.vueblog.busin.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxl.vueblog.busin.entity.User;
import com.lxl.vueblog.busin.mapper.UserMapper;
import com.lxl.vueblog.busin.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
