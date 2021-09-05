package com.dudu.springbootdemo1.gc;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/8/14 3:41 下午
 */
public class Demo3 {
    public static void main(String[] args) {
        byte[] array1 =new byte[4*1024*1024];
        array1 =null;
        byte[] array2 =new byte[2*1024*1024];
        byte[] array3 =new byte[2*1024*1024];
        byte[] array4 =new byte[2*1024*1024];
        byte[] array5 =new byte[128*1024];
        byte[] array6 =new byte[2*1024*1024];
    }
}

