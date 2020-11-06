package com.zx.cloud.security.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.cloud.security.model.User;
import com.zx.cloud.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxuan
 * @date 2020-07-20 14:31
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(new QueryWrapper<User>().eq("username",username));
        return new AuthUser(user);
    }
}
