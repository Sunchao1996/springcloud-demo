package com.sc.zull.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * what:    route之后调用
 *
 * @author 孙超 created on 2018/7/14
 */
@Component
public class PostFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return "post";
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
        logger.info("====post====");
//        throw new RuntimeException("post Exception");
        return null;
    }
}
