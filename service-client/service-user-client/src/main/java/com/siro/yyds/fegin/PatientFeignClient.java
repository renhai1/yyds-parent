package com.siro.yyds.fegin;

import com.siro.yyds.model.user.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author starsea
 * @date 2022-02-06
 */
@FeignClient(value = "service-user")
public interface PatientFeignClient {

    /**
     * 获取就诊人
     * @param id
     * @return
     */
    @GetMapping("/api/user/patient/inner/get/{id}")
    Patient getPatient(@PathVariable("id") Long id);
}
