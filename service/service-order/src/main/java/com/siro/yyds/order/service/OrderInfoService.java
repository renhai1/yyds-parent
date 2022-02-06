package com.siro.yyds.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.siro.yyds.model.order.OrderInfo;

/**
 * @author starsea
 * @date 2022-02-06
 */
public interface OrderInfoService extends IService<OrderInfo> {

    /**
     * 保存订单
     * @param scheduleId
     * @param patientId
     * @return
     */
    Long saveOrder(String scheduleId, Long patientId);

    /**
     * 根据订单id查询订单详情
     * @param orderId
     * @return
     */
    OrderInfo getOrder(String orderId);
}
