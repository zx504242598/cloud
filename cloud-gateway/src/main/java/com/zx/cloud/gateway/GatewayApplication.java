package com.zx.cloud.gateway;



import org.springframework.boot.SpringApplication;

import org.springframework.cloud.client.SpringCloudApplication;


/**
 * @author zhaoxuan
 */

@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
