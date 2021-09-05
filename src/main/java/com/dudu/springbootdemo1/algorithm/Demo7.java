package com.dudu.springbootdemo1.algorithm;

import java.util.Stack;

/**
 * @Description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * @author:zhaomeng
 * @date:2020/8/30 6:15 下午
 */
public class Demo7 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //设置一个栈
        Stack<Integer> stack=new Stack<>();
        if (pushA==null||popA==null||pushA.length==0||popA.length==0||pushA.length!=popA.length){
            return false;
        }
        int pushIndex=0;
        int popIndex=0;
        //还可以弹出元素
        while(popIndex<popA.length){
            while((stack.empty()||stack.peek()!=popA[popIndex])&&pushIndex<pushA.length){
                //往栈中加入元素
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }
            //不断弹出元素,栈在非空情况下才能弹出
            if (stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }else{
                return false;
            }
        }
        return true;
    }
}
