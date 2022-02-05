package com.siro.yyds.oss.controller;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.oss.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author starsea
 * @date 2022-02-05
 */
@RestController
@RequestMapping("/api/oss/file")
public class FileApiController {

    @Autowired
    private FileService fileService;

    /**
     * 上传文件到阿里云oss
     * @param file
     * @return
     */
    @PostMapping("/fileUpload")
    public Result fileUpload(MultipartFile file) {
        String url = fileService.upload(file);
        return Result.ok(url);
    }
}
