package com.dudu.springbootdemo1.config.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * 过滤器、拦截器的区别：
 * https://xie.infoq.cn/article/1e40f2d8c939ec8b24be78bf7?utm_medium=article
 * @author:zhaomeng
 * @date:2022/12/24 5:27 下午
 */

@Order(1)
//定义此过滤器在过滤器链中的位置，序号越小越先被执行
@WebFilter(filterName = "myFilter",urlPatterns = "/*")
//URL过滤配置
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //init方法，将在服务器启动时被调用
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("filter1"); // 调用filter链中的下一个filter
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String ip = httpServletRequest.getRemoteAddr();
        String url = httpServletRequest.getRequestURL().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String date = sdf.format(d);
        System.out.printf("%s %s 访问了 %s%n", date, ip, url);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //重写detory逻辑，该逻辑将在服务器关闭时被调用
    }
}
