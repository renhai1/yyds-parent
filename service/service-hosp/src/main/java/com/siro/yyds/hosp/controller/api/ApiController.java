package com.siro.yyds.hosp.controller.api;

import com.siro.yyds.common.exception.YydsException;
import com.siro.yyds.common.helper.HttpRequestHelper;
import com.siro.yyds.common.result.Result;
import com.siro.yyds.common.result.ResultCodeEnum;
import com.siro.yyds.common.util.MD5;
import com.siro.yyds.hosp.service.HospitalService;
import com.siro.yyds.hosp.service.HospitalSetService;
import com.siro.yyds.model.hosp.Hospital;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
        // 获取传递过来的医院信息
        Map<String, String[]> map = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(map);
        // 获取医院系统传递过来的签名
        String sign = (String) paramMap.get("sign");
        // 获取医院传递过来的医院编码，查询数据库的签名
        String hoscode = (String)paramMap.get("hoscode");
        if(StringUtils.isEmpty(hoscode)) {
            throw new YydsException(ResultCodeEnum.PARAM_ERROR);
        }
        String signKey = hospitalSetService.getSignKey(hoscode);
        // 把数据库查询的签名进行MD5加密
        String signMd5 = MD5.encrypt(signKey);
        if (!sign.equals(signMd5)) {
            throw new YydsException(ResultCodeEnum.SIGN_ERROR);
        }
        // 传输过程中“+”转换为了“ ”，因此我们要转换回来
        String logoData = (String)paramMap.get("logoData");
        logoData = logoData.replaceAll(" ","+");
        paramMap.put("logoData",logoData);
        hospitalService.save(paramMap);
        return Result.ok();
    }

    /**
     * 查询医院信息
     * @param request
     * @return
     */
    @ApiOperation(value = "查询医院")
    @PostMapping("/hospital/show")
    public Result getHospital(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(map);
        String hoscode = (String) paramMap.get("hoscode");
        String sign = (String) paramMap.get("sign");
        String signKey = hospitalSetService.getSignKey(hoscode);
        String signMd5 = MD5.encrypt(signKey);
        if (!sign.equals(signMd5)) {
            throw new YydsException(ResultCodeEnum.SIGN_ERROR);
        }
        Hospital hospital = hospitalService.getByHoscode(hoscode);
        return Result.ok(hospital);
    }

}
