package com.zx.cloud.common.interceptor;

import com.zx.cloud.common.exception.BaseException;
import com.zx.cloud.common.result.R;
import com.zx.cloud.common.utils.JsonUtil;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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
    public Object defaultExceptionHandler(HttpServletRequest request, Exception e) throws IOException {
        log.info("URI:"+request.getRequestURI());
        log.info("params:"+JsonUtil.encode(request.getParameterMap()));
        //log.info("params:"+ JsonUtil.decode(request.getReader(),String.class));
        log.error("系统异常:",e);
        if (e instanceof BaseException){
            BaseException exception=(BaseException) e;
            return R.error(exception);
        }
        return R.error();
    }
}
