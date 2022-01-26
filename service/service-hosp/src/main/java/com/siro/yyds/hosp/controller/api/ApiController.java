package com.siro.yyds.hosp.controller.api;

import com.siro.yyds.common.helper.HttpRequestHelper;
import com.siro.yyds.common.result.Result;
import com.siro.yyds.hosp.service.HospitalService;
import com.siro.yyds.hosp.service.HospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author starsea
 * @date 2022-01-26
 */
@Api(tags = "医院管理API接口")
@RestController
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    /**
     * 上传 医院的基本信息与规则信息
     * @return
     */
    @ApiOperation(value = "上传医院的基本信息与规则信息")
    @PostMapping("/saveHospital")
    public Result saveHospital(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        String hoscode = (String)paramMap.get("hoscode");
        System.out.println("hos111code = " + hoscode);
//        if(StringUtils.isEmpty(hoscode)) {
//            throw new YydsException(ResultCodeEnum.PARAM_ERROR);
//        }
//        if(!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YydsException(ResultCodeEnum.SIGN_ERROR);
//        }
        hospitalService.save(paramMap);
        return Result.ok();
    }

}
