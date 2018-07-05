package com.sc.book.service;

import com.sc.book.user.facade.UserFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by Administrator on 2018/7/5.
 */
@FeignClient("e-book-user")
public interface UserService  extends UserFacade{
}
