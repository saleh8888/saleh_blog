package com.lxl.vueblog.busin.controller;


import com.lxl.vueblog.common.Result;
import com.lxl.vueblog.busin.entity.User;
import com.lxl.vueblog.busin.service.UserService;
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
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){ return Result.success(user); }
}
