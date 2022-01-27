package com.siro.yyds.hosp.service;

import com.siro.yyds.model.hosp.Hospital;

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
}
