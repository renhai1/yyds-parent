package com.siro.yyds.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.siro.yyds.model.cmn.Dict;

import java.util.List;

/**
 * @author starsea
 * @date 2022-01-24
 */
public interface DictService extends IService<Dict> {
    /**
     * 根据数据id查询子数据列表
     * @param id
     * @return
     */
    List<Dict> findChildData(Long id);
}
