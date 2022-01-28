package com.siro.yyds.hosp.service;

import com.siro.yyds.model.hosp.Hospital;
import com.siro.yyds.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * @author starsea
 * @date 2022-01-26
 */
public interface HospitalService {
    /**
     * 保存医院的基本信息
     * @param paramMap
     */
    void save(Map<String, Object> paramMap);

    /**
     * 查询医院信息
     * @param hoscode
     * @return
     */
    Hospital getByHoscode(String hoscode);

    /**
     * 条件查询带分页
     * @param page 当前页数
     * @param limit 每页记录数
     * @param hospitalQueryVo 查询条件
     * @return
     */
    Page<Hospital> selectHospPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);

    /**
     * 更新上线状态
     * @param id
     * @param status
     */
    void updateHospStatus(String id, Integer status);

    /**
     * 医院详情
     * @param id
     * @return
     */
    Map<String, Object> showHospDetail(String id);
}
