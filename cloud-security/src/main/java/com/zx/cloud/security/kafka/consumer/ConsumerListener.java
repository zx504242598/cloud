package com.zx.cloud.security.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxuan
 * @date 2020-09-10 16:06
 **/
@Component
@Slf4j
public class ConsumerListener {
    //@KafkaListener(topics = "my-replicated-topic")
    public void onMessage(ConsumerRecord<String,String> consumerRecord,Acknowledgment ack){
        log.info("消费---->topic：{},message:{}",consumerRecord.topic(),consumerRecord.value());
        ack.acknowledge();
        //System.out.println(consumerRecord.value());
    }
}
