package com.siro.yyds.cmn.controller;

import com.siro.yyds.cmn.service.DictService;
import com.siro.yyds.common.result.Result;
import com.siro.yyds.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author starsea
 * @date 2022-01-24
 */
@Api(tags = "数据字典管理")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 根据数据id查询子数据列表
     * @param id
     * @return
     */
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("/findChildData/{id}")
    public Result findChildData(@PathVariable("id") Long id) {
        List<Dict> list = dictService.findChildData(id);
        return Result.ok(list);
    }

}
