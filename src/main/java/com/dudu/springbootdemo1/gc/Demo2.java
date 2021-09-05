package com.dudu.springbootdemo1.gc;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/8/14 3:28 下午
 */
public class Demo2 {
    public static void main(String[] args) {
        byte[] array1 =new byte[2*1024*1024];
        array1 =new byte[2*1024*1024];
        array1 =new byte[2*1024*1024]; //young gc之后存活
        byte[] array2 =new byte[128*1024]; //young gc之后存活
        array2 =null;
        byte[] array3 =new byte[2*1024*1024];
    }
}
