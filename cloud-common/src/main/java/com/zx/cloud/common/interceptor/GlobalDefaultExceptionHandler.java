package com.zx.cloud.common.interceptor;

import com.zx.cloud.common.exception.BaseException;
import com.zx.cloud.common.result.R;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxuan
 * @date 2020-07-02 14:34
 **/
@Slf4j
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object defaultExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("系统异常:",e);
        if (e instanceof BaseException){
            BaseException exception=(BaseException) e;
            return R.error(exception);
        }
        return R.error();
    }
}
