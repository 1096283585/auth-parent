package com.wugeek.auth.service;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @version 1.0.0
 * @auther guoshixiong
 * @date 2017/8/3
 * @QQ 718145966
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(ServiceApplication.class);
    }
}
