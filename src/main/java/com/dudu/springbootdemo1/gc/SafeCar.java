package com.dudu.springbootdemo1.gc;

import com.dudu.springbootdemo1.algorithm.Car;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/8/15 2:43 下午
 */
public class SafeCar extends Car {
    @Override
    public void go() {
        System.out.println("启动汽车之前，先进行安全检查。。。");
        super.go();
    }
}
