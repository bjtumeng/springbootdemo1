package com.dudu.springbootdemo1.algorithm;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/6 10:41 上午
 */
public class Demo11 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        //使用keyset遍历
        for (Integer i:map.keySet()){
            System.out.println(map.get(i));
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("id"+next+"---value"+map.get(next));
        }
    }
}
