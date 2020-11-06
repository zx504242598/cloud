package com.zx.cloud.security;



import com.spring4all.swagger.EnableSwagger2Doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author zhaoxuan
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2Doc
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

}
