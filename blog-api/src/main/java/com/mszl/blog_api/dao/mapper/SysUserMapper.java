package com.mszl.blog_api.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mszl.blog_api.dao.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     *  1、根据作者id查询用户信息
     * @param authorId
     * @return
     * */
    SysUser selectById(Long authorId);

}
