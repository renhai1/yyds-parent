package com.siro.yyds.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.siro.yyds.model.user.UserInfo;
import com.siro.yyds.vo.user.LoginVo;
import com.siro.yyds.vo.user.UserAuthVo;
import com.siro.yyds.vo.user.UserInfoQueryVo;

import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-03
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 用户手机号验证码登录
     * @param loginVo
     * @return
     */
    Map<String, Object> loginUser(LoginVo loginVo);

    /**
     * 根据微信openid获取用户信息
     * @param openid
     * @return
     */
    UserInfo getByOpenid(String openid);

    /**
     * 用户认证
     * @param userId
     * @param userAuthVo
     */
    void userAuth(Long userId, UserAuthVo userAuthVo);

    /**
     * 用户列表（条件查询带分页）
     * @param pageParam
     * @param userInfoQueryVo
     * @return
     */
    IPage<UserInfo> selectPage(Page<UserInfo> pageParam, UserInfoQueryVo userInfoQueryVo);
}
