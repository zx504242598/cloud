package com.zx.cloud.common.result;



import com.zx.cloud.common.constants.Code;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 *

 * 自定义响应数据结构
 *
 */
@Data
@Accessors(chain = true)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1576728571318750335L;

    /**
     * 响应业务状态
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应中的数据
     */
    private T data;

    public static <T> R<T> build(String code, String message, T data){
        return new R<T>().setCode(code).setMessage(message).setData(data);
    }

    public static <T> R<T> build(Result result, T data){
        return new R<T>().setCode(result.getCode()).setMessage(result.getMessage()).setData(data);
    }

    public static <T> R<T> ok(){
        return new R<T>().setCode(Code.OK.getCode()).setMessage(Code.OK.getMessage());
    }

    public static <T> R<T> ok(T data){
        return new R<T>().setCode(Code.OK.getCode()).setMessage(Code.OK.getMessage()).setData(data);
    }

    public static <T> R<T> error(){
        return new <T> R<T>().setCode(Code.SYSTEM_ERROR.getCode()).setMessage(Code.SYSTEM_ERROR.getMessage());
    }

    public static <T> R<T> error(T data){
        return new R<T>().setCode(Code.SYSTEM_ERROR.getCode()).setMessage(Code.SYSTEM_ERROR.getMessage()).setData(data);
    }

    public static <T> R<T> error(Result result){
        return new R<T>().setCode(result.getCode()).setMessage(result.getMessage());
    }

    public static <T> R<T> error(Result result, T data){
        return new R<T>().setCode(result.getCode()).setMessage(result.getMessage()).setData(data);
    }





}
