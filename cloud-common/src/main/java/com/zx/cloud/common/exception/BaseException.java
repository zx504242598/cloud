package com.zx.cloud.common.exception;


import com.zx.cloud.common.result.Result;

/**
 * @author zhaoxuan
 * @date 2020-07-02 14:24
 **/
public abstract class BaseException extends RuntimeException implements Result {


    private static final long serialVersionUID = 8024910539878349535L;
    /**
     * 异常错误码
     */
    protected String code;


    public BaseException(Result result) {
        super(result.getMessage());

        this.code=result.getCode();
    }

    public BaseException(String message, String code) {
        super(message);
        this.code = code;
    }

}
