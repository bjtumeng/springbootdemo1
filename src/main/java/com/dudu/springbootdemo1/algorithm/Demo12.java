package com.dudu.springbootdemo1.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/8 9:49 下午
 */
public class Demo12 {
    public static void main(String[] args) {
        AtomicInteger a=new AtomicInteger(5);
        a.getAndIncrement();
    }

}
