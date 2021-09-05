package com.dudu.springbootdemo1.algorithm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/11/3 8:23 下午
 */
public class Demo25 {
    ConcurrentHashMap<String, AtomicInteger> map=new ConcurrentHashMap<>();
    public Integer getNum(String ip){
        //1.判断ip存在则加1，ip不存在，新增元素，value为1
        if (map.containsKey(ip)){
            int value = map.get(ip).incrementAndGet();
            AtomicInteger atomicInteger=new AtomicInteger(value);
            map.put(ip,atomicInteger);
        }else{
            AtomicInteger atomicInteger=new AtomicInteger(1);
            map.put(ip,atomicInteger);
        }
        return map.get(ip).get();
    }
}
