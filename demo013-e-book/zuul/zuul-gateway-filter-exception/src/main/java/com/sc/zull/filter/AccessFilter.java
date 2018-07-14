package com.sc.zull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * what:    preFilter进行权限校验
 *
 * @author 孙超 created on 2018/7/14
 */
@Component
public class AccessFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器，做权限校验
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        logger.info("----pre2======");
        String token = request.getParameter("token");
        if (token == null || "".equals(token)) {
            //返回错误，不在进行传递
            logger.info("token is null======");
            //表示不再进行向下传递
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            rc.setResponseBody("{\"rsult\":\"token is null\"}");
            rc.getResponse().setContentType("text/html;charset=utf-8");
        } else {
            //操作redis判断是否有权限
            logger.info("token is ok");
        }
        return null;
    }
}
