package com.sc.zull.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * what:   过滤器执行时抛出异常执行 error类型过滤器
 *          报错时转发到/error地址，
 *
 * @author 孙超 created on 2018/7/14
 */
@Component
public class ErrorFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("-----error----");
        return null;
    }
}
