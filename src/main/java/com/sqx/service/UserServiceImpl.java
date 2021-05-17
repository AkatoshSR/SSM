package com.sqx.service;

import com.sqx.dao.UserMapper;
import com.sqx.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
