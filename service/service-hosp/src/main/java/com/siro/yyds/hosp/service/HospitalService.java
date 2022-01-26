package com.siro.yyds.hosp.service;

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
}
