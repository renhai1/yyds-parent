package com.siro.yyds.hosp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.siro.yyds.hosp.repository.DepartmentRepository;
import com.siro.yyds.hosp.service.DepartmentService;
import com.siro.yyds.model.hosp.Department;
import com.siro.yyds.vo.hosp.DepartmentQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author starsea
 * @date 2022-01-27
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * 上传科室信息
     * @param paramMap
     */
    @Override
    public void save(Map<String, Object> paramMap) {
        Department department = JSONObject.parseObject(JSONObject.toJSONString(paramMap), Department.class);
        //根据医院编号 和 科室编号查询
        Department targetDepartment = departmentRepository.getDepartmentByHoscodeAndDepcode(department.getHoscode(), department.getDepcode());
        if(null != targetDepartment) {
            BeanUtils.copyProperties(department, targetDepartment);
            departmentRepository.save(targetDepartment);
        } else {
            department.setCreateTime(new Date());
            department.setUpdateTime(new Date());
            department.setIsDeleted(0);
            departmentRepository.save(department);
        }
    }

    /**
     * 分页查询科室信息
     * @param page
     * @param limit
     * @param departmentQueryVo
     * @return
     */
    @Override
    public Page<Department> findPageDepartment(int page, int limit, DepartmentQueryVo departmentQueryVo) {

        Pageable pageable = PageRequest.of(page -1, limit);

        Department department = new Department();
        BeanUtils.copyProperties(departmentQueryVo,department);
        department.setIsDeleted(0);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true);
        Example<Department> example = Example.of(department,matcher);

        Page<Department> all = departmentRepository.findAll(example, pageable);
        return all;
    }

    /**
     * 删除科室信息
     * @param hoscode
     * @param depcode
     */
    @Override
    public void removeDepartment(String hoscode, String depcode) {
        Department targetDepartment = departmentRepository.getDepartmentByHoscodeAndDepcode(hoscode, depcode);
        if(null != targetDepartment) {
            departmentRepository.deleteById(targetDepartment.getId());
        }
    }
}
