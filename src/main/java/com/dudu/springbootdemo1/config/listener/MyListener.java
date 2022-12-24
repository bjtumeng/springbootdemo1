package com.dudu.springbootdemo1.config.listener;

import com.dudu.springbootdemo1.domain.User;
import com.dudu.springbootdemo1.user.servicce.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/24 8:33 下午
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        //用于写监听器的业务逻辑
        User user = myEvent.getUser();
        System.out.println("用户名："+user.getUsername());
        System.out.println("密码："+user.getPwd());
    }
}
