package com.zx.cloud.flowable.controller;

import com.zx.cloud.common.result.R;
import com.zx.cloud.flowable.exception.FlowableException;
import com.zx.cloud.flowable.vo.TaskVO;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;

/**
 * @author zhaoxuan
 * @date 2020-11-20 14:33
 **/
@RestController
@Api(tags = "流程申请")
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;


    /**
     * 添加报销
     *
     * @param userId    用户Id
     * @param money     报销金额
     * @param descption 描述
     */
    @PostMapping(value = "/add")
    public String addExpense(String userId, Integer money, String descption) {
        //启动流程
        HashMap<String, Object> map = new HashMap<>();
        map.put("taskUser", userId);
        map.put("money", money);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Expense", map);
        return "提交成功.流程Id为：" + processInstance.getId();
    }

    /**
     * 获取审批管理列表
     */
    @GetMapping(value = "/list")
    public R<?> list(String userId) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
        List<TaskVO> collect = tasks.stream().map(task -> {
            TaskVO taskVO = new TaskVO();
            taskVO.setId(task.getId());
            taskVO.setName(task.getName());
            return taskVO;
        }).collect(Collectors.toList());

        return R.ok(collect);
    }

    /**
     * 获取审批管理列表
     */
    @GetMapping(value = "/test")
    public R<?> test(String userId) {
        List<String> q=new ArrayList<>();
        q.add(userId);
        return R.ok(q);
    }

    /**
     * 批准
     *
     * @param taskId 任务ID
     */
    @GetMapping(value = "apply")
    public String apply(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new FlowableException("009","流程不存在");
        }
        //通过审核
        HashMap<String, Object> map = new HashMap<>();
        map.put("outcome", "通过");
        taskService.complete(taskId, map);
        return "processed ok!";
    }

    /**
     * 拒绝
     */

    @GetMapping(value = "reject")
    public String reject(String taskId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("outcome", "驳回");
        taskService.complete(taskId, map);
        return "reject";
    }
}