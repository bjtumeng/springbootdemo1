package com.dudu.springbootdemo1.retry.service.impl;

import com.dudu.springbootdemo1.retry.service.RetryService;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @Description:
 * value：抛出指定异常才会重试
 * include：和value一样，默认为空，当exclude也为空时，默认所有异常
 * exclude：指定不处理的异常
 * maxAttempts：最大重试次数，默认3次
 * backoff：重试等待策略，默认使用@Backoff，
 * @Backoff的value默认为1000L，我们设置为2000L；
 * multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，
 * 如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
 * 当前延迟时间= 上一次延迟时间 * multiplier
 * @author:zhaomeng
 * @date:2023/11/3 4:10 下午
 */
@Service
public class RetryServiceImpl implements RetryService {
    @Override
    @Retryable(value = Exception.class,maxAttempts = 7,backoff = @Backoff(delay = 2000,multiplier = 1.5))
    public int test(int code) throws Exception{
        System.out.println("test被调用,时间："+ LocalTime.now());
        if (code==0){
            throw new Exception("情况不对头！");
        }
        System.out.println("test被调用,情况对头了！");
        return 200;
    }

    @Recover
    public int recover(Exception e, int code){
        System.out.println("回调方法执行！！！！");
        //记日志到数据库 或者调用其余的方法
        return 400;
    }
}
