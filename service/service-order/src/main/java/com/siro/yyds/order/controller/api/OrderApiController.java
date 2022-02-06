package com.siro.yyds.order.controller.api;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.model.order.OrderInfo;
import com.siro.yyds.order.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author starsea
 * @date 2022-02-06
 */
@Api(tags = "订单api接口")
@RestController
@RequestMapping("/api/order/orderInfo")
public class OrderApiController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 创建订单
     * @param scheduleId
     * @param patientId
     * @return
     */
    @ApiOperation(value = "创建订单")
    @PostMapping("/auth/submitOrder/{scheduleId}/{patientId}")
    public Result submitOrder(
            @ApiParam(name = "scheduleId", value = "排班id", required = true)
            @PathVariable String scheduleId,
            @ApiParam(name = "patientId", value = "就诊人id", required = true)
            @PathVariable Long patientId) {
        Long order = orderInfoService.saveOrder(scheduleId, patientId);
        return Result.ok(order);
    }

    /**
     * 根据订单id查询订单详情
     * @param orderId
     * @return
     */
    @ApiOperation(value = "根据订单id查询订单详情")
    @GetMapping("/auth/getOrders/{orderId}")
    public Result getOrders(@PathVariable("orderId") String orderId) {
        OrderInfo orderInfo = orderInfoService.getOrder(orderId);
        return Result.ok(orderInfo);
    }
}
