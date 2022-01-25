package com.siro.yyds.cmn.controller;

import com.siro.yyds.cmn.service.DictService;
import com.siro.yyds.common.result.Result;
import com.siro.yyds.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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

    /**
     * 数据字典导出
     * @param response
     * @return
     */
    @ApiOperation(value = "数据字典导出")
    @GetMapping("/exportData")
    public Result exportData(HttpServletResponse response) {
        dictService.exportData(response);
        return Result.ok();
    }

    /**
     * 数据字典导入
     * @param file
     * @return
     */
    @ApiOperation(value = "数据字典导入")
    @PostMapping("/importData")
    public Result importData(MultipartFile file) {
        dictService.importData(file);
        return Result.ok();
    }

}
