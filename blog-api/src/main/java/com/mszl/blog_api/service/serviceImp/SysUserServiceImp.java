package com.mszl.blog_api.service.serviceImp;

import com.mszl.blog_api.dao.mapper.SysUserMapper;
import com.mszl.blog_api.dao.pojo.SysUser;
import com.mszl.blog_api.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImp implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setNickname("lxc");
        }
        return sysUser;
    }
}
