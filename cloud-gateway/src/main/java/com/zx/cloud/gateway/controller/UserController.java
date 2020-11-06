package com.zx.cloud.gateway.controller;

import com.zx.cloud.common.result.R;
import com.zx.cloud.gateway.feign.RemoteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author zhaoxuan
 * @date 2020-11-06 09:29
 **/
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {
    @Autowired
    RemoteUserService remoteUserService;
    @GetMapping("/list")
    public R<?> list(){
        return R.ok(remoteUserService.list().getData());
    }
}
