package com.dudu.springbootdemo1.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/9/5 5:49 下午
 */
@Service
public class AsyncService {


    public void async()  {
            test1();
            test2();
    }
    @Async
    public Future<String> test1 (){
        System.out.println("test1开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("test1完成");
        return new AsyncResult<>("test1返回值");
    }

    @Async
    public void test2 ()  {
        System.out.println("test2开始");
        System.out.println("test2完成");
    }
}
