package com.code.wings.exambooster.dao;

import com.code.wings.exambooster.entity.User;

public interface UserDao {
    public User findByUserName(String userName);

    public void save(User user);

}
