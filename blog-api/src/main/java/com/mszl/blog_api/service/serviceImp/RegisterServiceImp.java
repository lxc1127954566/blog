package com.mszl.blog_api.service.serviceImp;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mszl.blog_api.Utils.JWTUtils;
import com.mszl.blog_api.dao.pojo.SysUser;
import com.mszl.blog_api.service.RegisterService;
import com.mszl.blog_api.service.SysUserService;
import com.mszl.blog_api.vo.ErrorCode;
import com.mszl.blog_api.vo.Result;
import com.mszl.blog_api.vo.params.LoginParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RegisterServiceImp implements RegisterService {

    private static final String salt = "lxc123!!@#";

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * 1、判断参数是否合法
     * 2、判断账户是否存在
     * 存在-》返回账户存在 不存在-》 注册
     * 3、生成token
     * 4、存入redis 并返回
     * 5、加上事务 失败则回滚
     * */
    @Override
    public Result register(LoginParams loginParams) {
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        String nickname = loginParams.getNickname();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password) || StringUtils.isBlank(nickname)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        SysUser sysUser = sysUserService.findByAccount(account);
        if (sysUser != null){
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }
        sysUser = new SysUser();
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(DigestUtils.md5Hex(password+salt));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(sysUser.getLastLogin());
        sysUser.setSalt(salt);
        this.sysUserService.save(sysUser);

        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser),1, TimeUnit.DAYS);
        return Result.success(token);
    }
}
