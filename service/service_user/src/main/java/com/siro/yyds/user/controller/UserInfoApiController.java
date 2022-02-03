package com.siro.yyds.user.controller;

import com.siro.yyds.common.result.Result;
import com.siro.yyds.common.util.IpUtil;
import com.siro.yyds.user.service.UserInfoService;
import com.siro.yyds.vo.user.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-03
 */
@Api(tags = "用户模块")
@RestController
@RequestMapping("/api/user")
public class UserInfoApiController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户手机号验证码登录
     * @param loginVo
     * @param request
     * @return
     */
    @ApiOperation(value = "用户手机号验证码登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        loginVo.setIp(IpUtil.getIpAddr(request));
        Map<String, Object> info = userInfoService.loginUser(loginVo);
        return Result.ok(info);
    }
}
