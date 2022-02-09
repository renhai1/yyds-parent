package com.siro.yyds.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.siro.yyds.model.order.OrderInfo;
import com.siro.yyds.vo.order.OrderCountQueryVo;
import com.siro.yyds.vo.order.OrderCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author starsea
 * @date 2022-02-06
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    /**
     * 查询预约统计的数据
     * @param orderCountQueryVo
     * @return
     */
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);
}
