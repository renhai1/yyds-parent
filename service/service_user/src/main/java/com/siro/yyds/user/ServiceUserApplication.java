package com.siro.yyds.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 登录方式：
 *  1. 手机号+手机验证码
 *  2. 微信扫描
 * 无注册界面，第一次登录根据手机号判断系统是否存在，如果不存在则自动注册。
 * 微信扫描登录成功必须绑定手机号码，即：第一次扫描成功后绑定手机号，以后登录扫描直接登录成功。
 * 网关统一判断登录状态，如何需要登录，页面弹出登录层
 *
 * @author starsea
 * @date 2022-02-03
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.siro.yyds")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.siro.yyds")
@MapperScan("com.siro.yyds.user.mapper")
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

}
