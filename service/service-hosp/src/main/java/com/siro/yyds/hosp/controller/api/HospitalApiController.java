package com.siro.yyds.hosp.controller.api;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.hosp.service.DepartmentService;
import com.siro.yyds.hosp.service.HospitalService;
import com.siro.yyds.model.hosp.Hospital;
import com.siro.yyds.vo.hosp.DepartmentVo;
import com.siro.yyds.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-02
 */
@Api(tags = "医院管理接口")
@RestController
@RequestMapping("/api/hosp/hospital")
public class HospitalApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 分页查询医院列表
     * @param page
     * @param limit
     * @param hospitalQueryVo
     * @return
     */
    @ApiOperation(value = "分页查询医院列表")
    @GetMapping("/findHospList/{page}/{limit}")
    public Result findHospList(@PathVariable("page") Integer page, @PathVariable("limit") Integer limit,
                        HospitalQueryVo hospitalQueryVo) {
        // 显示上线的医院
//        hospitalQueryVo.setStatus(1);
        Page<Hospital> pageModel = hospitalService.selectHospPage(page, limit, hospitalQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 根据医院名称获取医院列表
     * @param hosname
     * @return
     */
    @ApiOperation(value = "根据医院名称获取医院列表")
    @GetMapping("/findByHosname/{hosname}")
    public Result findByHosname(@PathVariable("hosname") String hosname) {
        List<Hospital> list = hospitalService.findByHosname(hosname);
        return Result.ok(list);
    }

    /**
     * 根据医院编号，查询医院所有科室列表
     * @param hoscode
     * @return
     */
    @ApiOperation(value = "获取科室列表")
    @GetMapping("/department/{hoscode}")
    public Result index(@PathVariable("hoscode") String hoscode) {
        List<DepartmentVo> voList = departmentService.findDeptTree(hoscode);
        return Result.ok(voList);
    }

    /**
     * 根据医院编号，查询医院预约挂号详情
     * @param hoscode
     * @return
     */
    @ApiOperation(value = "医院预约挂号详情")
    @GetMapping("/findHospDetail/{hoscode}")
    public Result item(@PathVariable("hoscode") String hoscode) {
        Map<String, Object> map = hospitalService.item(hoscode);
        return Result.ok(map);
    }
}
