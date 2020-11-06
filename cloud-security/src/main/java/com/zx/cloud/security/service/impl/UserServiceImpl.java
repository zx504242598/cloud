package com.zx.cloud.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.cloud.common.constants.Code;
import com.zx.cloud.security.exception.UserException;
import com.zx.cloud.security.service.UserService;
import com.zx.cloud.security.mapper.UserMapper;
import com.zx.cloud.security.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author root
 * @since 2020-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    /**
     * 用户注册
     *
     * @param user
     */
    @Override
    public void register(User user) {
        int count = count(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (count==0){
            user.setRole("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.insert();

        }else {
            throw new UserException(Code.USER_EXIST);
        }
    }
}
