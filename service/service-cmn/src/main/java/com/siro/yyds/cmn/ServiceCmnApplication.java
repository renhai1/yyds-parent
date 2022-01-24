package com.siro.yyds.cmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author starsea
 * @date 2022-01-24
 */
@ComponentScan(basePackages = "com.siro.yyds")
@SpringBootApplication
public class ServiceCmnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCmnApplication.class, args);
    }

}
