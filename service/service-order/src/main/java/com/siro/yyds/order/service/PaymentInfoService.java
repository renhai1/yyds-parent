package com.siro.yyds.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.siro.yyds.model.order.OrderInfo;
import com.siro.yyds.model.order.PaymentInfo;

import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-08
 */
public interface PaymentInfoService extends IService<PaymentInfo> {

    /**
     * 保存交易记录
     * @param orderInfo
     * @param paymentType 支付类型（1：微信 2：支付宝）
     */
    void savePaymentInfo(OrderInfo orderInfo, Integer paymentType);

    /**
     * 支付成功
     * @param outTradeNo
     * @param paymentType
     * @param paramMap
     */
    void paySuccess(String outTradeNo, Integer paymentType, Map<String, String> paramMap);

    /**
     * 获取支付记录
     * @param orderId
     * @param paymentType
     * @return
     */
    PaymentInfo getPaymentInfo(Long orderId, Integer paymentType);
}
