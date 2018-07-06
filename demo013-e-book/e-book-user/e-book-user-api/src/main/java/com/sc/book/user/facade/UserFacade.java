package com.sc.book.user.facade;

import com.sc.book.user.domain.User;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * what:接口里面的方法体怎么写，实现类和使用的时候就怎么写
 *
 * @author 孙超 created on 2018/4/7
 */
@RequestMapping("/user")
public interface UserFacade {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    Integer login(@RequestParam("userName") String userName, @RequestParam("password") String password);

}
