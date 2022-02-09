package com.siro.yyds.fegin;

import com.siro.yyds.vo.order.OrderCountQueryVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-09
 */
@FeignClient(value = "service-order")
public interface OrderFeignClient {

    /**
     * 获取订单统计数据
     */
    @PostMapping("/admin/order/orderInfo/inner/getCountMap")
    Map<String, Object> getCountMap(@RequestBody OrderCountQueryVo orderCountQueryVo);
}
