package com.dudu.springbootdemo1.algorithm;


public class Demo1 {
    public static void main(String[] args) {
        byte[] array1 =new byte[2*1024*1024];
        array1 =new byte[2*1024*1024];
        array1 =new byte[2*1024*1024]; //young gc之后存活
        byte[] array2 =new byte[128*1024]; //young gc之后存活
        array2 =null;
        byte[] array3 =new byte[2*1024*1024];
    }
}
