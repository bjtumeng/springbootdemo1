package com.dudu.springbootdemo1.gc;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:cglib代理生成大量类造成metaspace内存溢出
 * @author:zhaomeng
 * @date:2021/8/15 2:33 下午
 */
public class Demo6 {
    public static void main(String[] args) {
        long counter =0;
        while(true){
            Enhancer enhancer =new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("go")){
                        System.out.println("启动汽车之前，先进行安全检查。。。");
                        return methodProxy.invokeSuper(o,objects);
                    }else{
                        return methodProxy.invokeSuper(o,objects);
                    }
                }
            });
            Car car =(Car) enhancer.create();
            car.go();
            System.out.println("目前创建了"+(++counter)+"个Car类的子类");
        }
    }
}
class Car{
    public void go(){
        System.out.println("启动汽车之前，先进行安全检查。。。");
    }
}

