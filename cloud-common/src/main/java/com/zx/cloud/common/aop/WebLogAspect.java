package com.zx.cloud.common.aop;


import com.zx.cloud.common.utils.JsonUtil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;


/**
 * @author zhaoxuan
 * @date 2021-01-22 11:09
 **/

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.zx.cloud.*.controller.*.*(..))")
    private void controllerLogAspect() {
    }

    @Before("controllerLogAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        log.info("--------------请求内容--------------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 记录下请求内容
        log.info("url : " + request.getRequestURL().toString());
        log.info("http_method : " + request.getMethod());
        log.info("ip : " + request.getRemoteAddr());
        log.info("params: " + Arrays.toString(joinPoint.getArgs()));
        log.info("class_method : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }


    @AfterReturning(returning = "returnObject", pointcut = "controllerLogAspect()")
    public void methodReturing(Object returnObject) {
        log.info("--------------返回内容--------------");
        log.info(JsonUtil.encode(returnObject));
    }


}
