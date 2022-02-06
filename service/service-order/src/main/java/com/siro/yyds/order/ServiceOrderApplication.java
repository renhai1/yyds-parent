package com.siro.yyds.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author starsea
 * @date 2022-02-06
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.siro.yyds"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.siro.yyds"})
public class ServiceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }

}
