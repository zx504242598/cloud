package com.zx.cloud.common.constants;

import com.zx.cloud.common.result.Result;

/**
 * @author zhaoxuan
 * @date 2020-07-02 14:55
 **/
public enum  Code implements Result {


    /**
     * 用户已存在
     */
    USER_EXIST("001","用户已存在"),
    /**
     * 成功
     */
    OK("200","成功"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("500","系统异常");

    private final String code;

    private final String message;

    private Code(String code,String message) {
        this.code=code;
        this.message=message;
    }

    /**
     * code
     *
     * @return
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * 信息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return this.message;
    }
}
