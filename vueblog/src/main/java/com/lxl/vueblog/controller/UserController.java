package com.lxl.vueblog.controller;


import com.lxl.vueblog.common.Result;
import com.lxl.vueblog.entity.User;
import com.lxl.vueblog.service.UserService;
import com.lxl.vueblog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Saleh
 * @since 2022-02-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    IMUserService imUserService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result index(@PathVariable("id") Long id) {
        User user = new User();
        return Result.success(user);


//        UserService userService = new UserServiceImpl();
       // return userService.getById(id);
    }
    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){ return Result.success(user); }
}
