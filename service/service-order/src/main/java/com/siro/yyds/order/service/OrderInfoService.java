package com.siro.yyds.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.siro.yyds.model.order.OrderInfo;
import com.siro.yyds.vo.order.OrderQueryVo;

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

    /**
     * 订单列表（条件查询带分页）
     * @param pageParam
     * @param orderQueryVo
     * @return
     */
    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);
}
