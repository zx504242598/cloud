package com.zx.cloud.security.controller;


import com.zx.cloud.security.model.User;
import com.zx.cloud.common.result.R;
import com.zx.cloud.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2020-06-30
 */
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public R<?> list(){
        return R.ok(userService.list());
    }

    @PostMapping("/notAuth/register")
    public R<?> register(@Validated@RequestBody User user){
        userService.register(user);
        return R.ok();
    }

}

