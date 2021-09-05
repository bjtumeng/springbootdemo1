package com.dudu.springbootdemo1.algorithm;

/***     8
 *    /    \
 *   6     10
 *  /  \   / \
 * 5   7  9  11
 * @author:zhaomeng
 * @date:2020/10/15 8:10 下午
 */
public class Demo24 {
    int x;
   volatile boolean flag;
   public void writer(){
       x=42;
       flag=true;
   }
   public void read(){
       System.out.println(x);
   }
}
