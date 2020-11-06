package com.zx.cloud.security.service;

import com.zx.cloud.security.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author root
 * @since 2020-06-30
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param user
     */
    void register(User user);
}
