package com.dudu.springbootdemo1.user.servicce;

import com.dudu.springbootdemo1.config.listener.MyEvent;
import com.dudu.springbootdemo1.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/24 8:34 下午
 */
@Service
public class UserService {
    @Resource
    private ApplicationContext applicationContext;

    public User getUser2(){
        User user = new User(10002, "李四", "147258");
        //发布事件
        MyEvent myEvent = new MyEvent(this,user);
        applicationContext.publishEvent(myEvent);
        return user;
    }
}
