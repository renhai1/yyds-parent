package com.siro.yyds.hosp.controller;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.hosp.service.HospitalService;
import com.siro.yyds.model.hosp.Hospital;
import com.siro.yyds.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @author starsea
 * @date 2022-01-28
 */
@Api(tags = "医院管理")
@RestController
@RequestMapping("/admin/hosp/hospital")
@CrossOrigin
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    /**
     * 条件查询带分页
     * @param page 当前页数
     * @param limit 每页记录数
     * @param hospitalQueryVo 查询条件
     * @return
     */
    @ApiOperation(value = "条件查询带分页")
    @GetMapping("/findPageHospital/{page}/{limit}")
    public Result findPageHospital(@PathVariable("page") Integer page,
                                  @PathVariable("limit") Integer limit,
                                  @RequestBody(required = false) HospitalQueryVo hospitalQueryVo) {
        Page<Hospital> hospitalPage = hospitalService.selectHospPage(page, limit, hospitalQueryVo);
        return Result.ok(hospitalPage);
    }

}
