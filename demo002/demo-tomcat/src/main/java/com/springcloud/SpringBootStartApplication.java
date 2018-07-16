package com.springcloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * what:修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 *
 * @author 孙超 created on 2018/7/16
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里一定要指向原先用main方法执行的Application启动类
        return builder.sources(DemoTomcatApplication.class);
    }
}
