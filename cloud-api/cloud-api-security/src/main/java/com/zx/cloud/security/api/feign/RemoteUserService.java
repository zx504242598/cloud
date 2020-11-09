package com.zx.cloud.security.api.feign;


import com.zx.cloud.common.result.R;
import com.zx.cloud.security.api.feign.fallback.RemoteUserServiceFallbackFactory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhaoxuan
 */
@FeignClient(contextId = "remoteUserService",value = "cloud-security",fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {

    @GetMapping("/user/list")
     R<?> list();
}
