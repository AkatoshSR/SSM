package com.sqx.dao;

import com.sqx.pojo.User;

import java.util.List;

public interface UserMapper {

    // 获得用户列表
    List<User> getUserList();

}
