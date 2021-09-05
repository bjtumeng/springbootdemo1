package com.dudu.springbootdemo1.algorithm;

import java.util.HashMap;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/18 9:07 下午
 */
public class Demo15 {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(17));
        HashMap<String,String> hashMap=new HashMap<>(100);
        hashMap.put("1","2");
    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1000000) ? 100000000: n + 1;
    }
}
