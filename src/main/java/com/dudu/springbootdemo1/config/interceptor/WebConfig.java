package com.dudu.springbootdemo1.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/24 5:18 下午
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加Web项目的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 对所有访问路径，都通过MyInterceptor类型的拦截器进行拦截
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                //放行登录页，登陆操作，静态资源
                .excludePathPatterns("/", "/login", "/index.html", "/user/login",
                        "/css/**", "/images/**", "/js/**", "/fonts/**");
    }
}
