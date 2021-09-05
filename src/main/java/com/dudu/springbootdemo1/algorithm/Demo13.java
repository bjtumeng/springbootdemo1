package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/9 7:39 下午
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        String s1 =new String("abc");
        String s2 =new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }

}
