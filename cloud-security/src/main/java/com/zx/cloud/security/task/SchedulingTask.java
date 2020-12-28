package com.zx.cloud.security.task;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zhaoxuan
 * @date 2020-12-02 14:42
 **/
//@Component
//@EnableScheduling
public class SchedulingTask implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addCronTask(() -> System.out.println(LocalDateTime.now()), "*/5 * 8-22 * * ?");
    }
}
