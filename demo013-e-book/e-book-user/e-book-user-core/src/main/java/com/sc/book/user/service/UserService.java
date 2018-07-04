package com.sc.book.user.service;


import com.sc.book.user.domain.User;
import com.sc.book.user.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * what:   商品service
 *
 * @author 孙超 created on 2018/7/4
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Integer login(String userName, String password) {
        System.out.println(userName+"-"+password);
        return userMapper.login(userName, password);
    }
}
