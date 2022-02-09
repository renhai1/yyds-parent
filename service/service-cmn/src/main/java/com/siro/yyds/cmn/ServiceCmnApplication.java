package com.siro.yyds.cmn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author starsea
 * @date 2022-01-24
 */
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.siro.yyds")
@SpringBootApplication
@MapperScan("com.siro.yyds.cmn.mapper")
public class ServiceCmnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }

}
