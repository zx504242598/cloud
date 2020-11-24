package com.zx.cloud.flowable.vo;

import java.util.Map;

import lombok.Data;

/**
 * @author zhaoxuan
 * @date 2020-11-20 16:17
 **/
@Data
public class TaskVO {
    private String id;

    private String taskName;

    private Map<String,Object> variables;

}
