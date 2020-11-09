package com.zx.cloud.security.api.feign.fallback;

import com.zx.cloud.common.result.R;
import com.zx.cloud.security.api.feign.RemoteUserService;


import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxuan
 * @date 2020-11-06 09:21
 **/
@Component
@Slf4j
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return () -> R.error("获取用户列表失败:" + throwable.getMessage());
    }
}
