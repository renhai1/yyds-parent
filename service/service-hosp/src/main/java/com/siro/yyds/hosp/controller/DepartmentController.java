package com.siro.yyds.hosp.controller;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.hosp.service.DepartmentService;
import com.siro.yyds.vo.hosp.DepartmentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author starsea
 * @date 2022-01-28
 */
@Api(tags = "科室管理")
@RestController
@RequestMapping("/admin/hosp/department")
//@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 根据医院编号，查询医院所有科室列表
     * @param hoscode
     * @return
     */
    @ApiOperation(value = "查询医院所有科室列表")
    @GetMapping("/getDeptList/{hoscode}")
    public Result getDeptList(@PathVariable("hoscode") String hoscode) {
        List<DepartmentVo> list = departmentService.findDeptTree(hoscode);
        return Result.ok(list);
    }
}
