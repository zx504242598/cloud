package com.zx.cloud.security.exception;

import com.zx.cloud.common.exception.BaseException;
import com.zx.cloud.common.result.Result;

/**
 * @author zhaoxuan
 * @date 2020-07-02 15:16
 **/

public class UserException extends BaseException {


    private static final long serialVersionUID = -1168855137600361083L;

    public UserException(Result result) {
        super(result);
    }

    public UserException(String message, String code) {
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
