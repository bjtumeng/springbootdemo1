package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/1/3 12:48 下午
 */
public class SimpleFactory {
    public Car createCar(){
        //增加权限、日志等控制
        return new Car();
    }

    public Plane createPlane(){
        //增加权限、日志等控制
        return new Plane();
    }
}
