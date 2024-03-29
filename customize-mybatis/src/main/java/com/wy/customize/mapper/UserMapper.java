package com.wy.customize.mapper;

import com.wy.customize.pojo.User;

import java.util.List;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname UserMapper
 * @Description
 */

public interface UserMapper {
    /**
     * 获取全部的用户信息
     * @return
     */
//    public List<User> selectList() throws Exception;

    /**
     * 获取指定的用户信息
     * @return
     */
//    public User selectOne(User user) throws Exception;

    public List<User> findAll();

    public User findOne();
}
