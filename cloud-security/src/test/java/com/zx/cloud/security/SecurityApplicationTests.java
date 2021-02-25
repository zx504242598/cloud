package com.zx.cloud.security;

import com.zx.cloud.security.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SecurityApplicationTests {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void contextLoads() {
        String key = "user:1";
        User user1 = new User();
        user1.setUsername("zxzx").setPassword("123");
        redisTemplate.opsForValue().set(key, user1);
        User user = (User) redisTemplate.opsForValue().get(key);
        log.info("uesr: "+user.toString());

    }

    public static void main(String[] args) {

    }

}
