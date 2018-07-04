package com.sc.book.user.facade;


import com.sc.book.user.domain.User;
import com.sc.book.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
@RestController
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;

    @Override
    public Integer login(String userName, String password) {
        return userService.login(userName,password);
    }
}
