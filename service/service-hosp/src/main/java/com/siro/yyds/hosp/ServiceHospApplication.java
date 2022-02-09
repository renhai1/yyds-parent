package com.siro.yyds.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author starsea
 * @date 2022-01-21
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.siro.yyds")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.siro.yyds")
@MapperScan("com.siro.yyds.hosp.mapper")
public class ServiceHospApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }

}
