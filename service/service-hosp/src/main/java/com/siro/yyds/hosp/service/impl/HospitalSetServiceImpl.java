package com.siro.yyds.hosp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siro.yyds.model.hosp.HospitalSet;
import com.siro.yyds.hosp.mapper.HospitalSetMapper;
import com.siro.yyds.hosp.service.HospitalSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author starsea
 * @date 2022-01-21
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    @Autowired
    private HospitalSetMapper hospitalSetMapper;

}
