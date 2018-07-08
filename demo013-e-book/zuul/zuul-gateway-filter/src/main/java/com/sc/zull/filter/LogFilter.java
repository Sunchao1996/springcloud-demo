package com.sc.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * what:    服务网关过滤器
 *
 * @author 孙超 created on 2018/7/8
 */
@Component
public class LogFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    /**
     * 过滤器的类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的顺序，越小越先执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否使用此过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器执行的逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        logger.info("method={},url={}", request.getMethod(), request.getRequestURL());
        return null;
    }
}
