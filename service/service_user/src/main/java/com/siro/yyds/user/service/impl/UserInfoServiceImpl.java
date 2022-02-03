package com.siro.yyds.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.siro.yyds.common.exception.YydsException;
import com.siro.yyds.common.result.ResultCodeEnum;
import com.siro.yyds.common.util.JwtHelper;
import com.siro.yyds.model.user.UserInfo;
import com.siro.yyds.user.mapper.UserInfoMapper;
import com.siro.yyds.user.service.UserInfoService;
import com.siro.yyds.vo.user.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author starsea
 * @date 2022-02-03
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 用户手机号验证码登录
     * @param loginVo
     * @return
     */
    @Override
    public Map<String, Object> loginUser(LoginVo loginVo) {
        String phone = loginVo.getPhone();
        String code = loginVo.getCode();
        // 判断手机号和验证码是否为空
        if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(code)) {
            throw new YydsException(ResultCodeEnum.PARAM_ERROR);
        }

        // TODO 判断手机验证码和输入的验证码是否一致
        String mobleCode = redisTemplate.opsForValue().get(phone);
        if(!code.equals(mobleCode)) {
            throw new YydsException(ResultCodeEnum.CODE_ERROR);
        }

        // 判断是否第一次登录，根据手机号查询数据库，如果不存在相同的手机号就是第一次登录
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        UserInfo userInfo = baseMapper.selectOne(queryWrapper);
        if(null == userInfo) {
            // 注册信息到数据库
            userInfo = new UserInfo();
            userInfo.setName("");
            userInfo.setPhone(phone);
            userInfo.setStatus(1);
            this.save(userInfo);
        }

        // 校验是否被禁用
        if(userInfo.getStatus() == 0) {
            throw new YydsException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }

        // 返回登录信息
        Map<String, Object> map = new HashMap<>();
        String name = userInfo.getName();
        if(StringUtils.isEmpty(name)) {
            name = userInfo.getNickName();
        }
        if(StringUtils.isEmpty(name)) {
            name = userInfo.getPhone();
        }
        // 返回登录用户名
        map.put("name", name);
        // TODO 返回token信息，jwt生成token字符串
        String token = JwtHelper.createToken(userInfo.getId(), name);
        map.put("token",token);

        return map;
    }
}
