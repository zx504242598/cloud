package com.zx.cloud.flowable.exception;


import com.zx.cloud.common.exception.BaseException;
import com.zx.cloud.common.result.Result;

/**
 * @author zhaoxuan
 * @date 2020-07-21 14:44
 **/
public class FlowableException extends BaseException {


    private static final long serialVersionUID = -1168855137600361083L;

    public FlowableException(Result result) {
        super(result);
    }

    public FlowableException(String message, String code) {
        super(message, code);
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
}
