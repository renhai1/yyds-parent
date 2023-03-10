package com.siro.yyds.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siro.yyds.common.result.Result;
import com.siro.yyds.enums.OrderStatusEnum;
import com.siro.yyds.model.order.OrderInfo;
import com.siro.yyds.order.service.OrderInfoService;
import com.siro.yyds.vo.order.OrderCountQueryVo;
import com.siro.yyds.vo.order.OrderQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-06
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("/admin/order/orderInfo")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 订单分页列表
     * @param page
     * @param limit
     * @param orderQueryVo
     * @return
     */
    @ApiOperation(value = "订单分页列表")
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable("page") Long page,
                       @PathVariable("limit") Long limit,
                       OrderQueryVo orderQueryVo) {
        Page<OrderInfo> pageParam = new Page<>(page,limit);
        IPage<OrderInfo> pageModel = orderInfoService.selectPage(pageParam, orderQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 获取订单状态
     * @return
     */
    @ApiOperation(value = "获取订单状态")
    @GetMapping("/getStatusList")
    public Result getStatusList() {
        return Result.ok(OrderStatusEnum.getStatusList());
    }

    /**
     * 订单详情
     * @param id
     * @return
     */
    @ApiOperation(value = "订单详情")
    @GetMapping("/show/{id}")
    public Result getDetail(
            @ApiParam(name = "orderId", value = "订单id", required = true)
            @PathVariable Long id) {
        return Result.ok(orderInfoService.showDetail(id));
    }

    /**
     * 获取订单统计数据
     * @param orderCountQueryVo
     * @return
     */
    @ApiOperation(value = "获取订单统计数据")
    @PostMapping("/inner/getCountMap")
    public Map<String, Object> getCountMap(@RequestBody OrderCountQueryVo orderCountQueryVo) {
        return orderInfoService.getCountMap(orderCountQueryVo);
    }
}
