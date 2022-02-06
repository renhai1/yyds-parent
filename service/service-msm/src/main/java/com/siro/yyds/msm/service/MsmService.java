package com.siro.yyds.msm.service;

import com.siro.yyds.vo.msm.MsmVo;

/**
 * @author starsea
 * @date 2022-02-03
 */
public interface MsmService {

    /**
     * 发送手机号验证码
     * @param phone
     * @param code
     * @return
     */
    boolean send(String phone, String code);

    /**
     * mq发送短信
     * @param msmVo
     * @return
     */
    boolean send(MsmVo msmVo);
}
