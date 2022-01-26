package com.siro.yyds.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.siro.yyds.model.hosp.HospitalSet;

/**
 * @author starsea
 * @date 2022-01-21
 */
public interface HospitalSetService extends IService<HospitalSet> {

    /**
     * 获取签名key
     * @param hoscode
     * @return
     */
    String getSignKey(String hoscode);
}
