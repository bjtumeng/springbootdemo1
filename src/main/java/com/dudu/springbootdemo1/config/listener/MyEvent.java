package com.dudu.springbootdemo1.config.listener;

import com.dudu.springbootdemo1.domain.User;
import org.springframework.context.ApplicationEvent;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/24 8:30 下午
 */
public class MyEvent extends ApplicationEvent {
    //模拟数据
    private User user;

    public MyEvent(Object source,User user) {
        super(source);
        this.user  = user;
    }

    /**
     * @description 获取事件中用户信息
     * @return User
     */
    public User getUser(){
        return user;
    }
}
