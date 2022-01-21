package com.siro.yyds.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author starsea
 * @date 2022-01-21
 */
@ComponentScan(basePackages = "com.siro.yyds")
@SpringBootApplication
public class ServiceHospApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }

}
