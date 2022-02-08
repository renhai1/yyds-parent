package com.siro.yyds.order.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信支付参数类
 * @author starsea
 * @date 2022-02-08
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${weixin.appid}")
    private String appid;

    @Value("${weixin.partner}")
    private String partner;

    @Value("${weixin.partnerkey}")
    private String partnerkey;

    public static String APPID;
    public static String PARTNER;
    public static String PARTNERKEY;

    @Override
    public void afterPropertiesSet() {
        APPID = appid;
        PARTNER = partner;
        PARTNERKEY = partnerkey;
    }
}
