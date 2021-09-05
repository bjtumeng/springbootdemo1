package com.dudu.springbootdemo1.algorithm;

import java.util.ArrayList;

public class Demo6 {

    public static void main(String[] args) {
        int[] array={2,4,3,6,3,2,5,5};
        int[] num1=new int[1];
        int[] num2=new int[1];
        FindNumsAppearOnce(array,num1,num2);
    }


   //num1,num2分别为长度为1的数组。传出参数
   //将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result=array[0];
        for (int i=1;i<array.length;i++){
             result^=array[i];
         }
        int count=1;
        while(result!=0){
            if (result%2==1){
                break;
            }else {
                result/=2;
                count++;
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        //以result的第count位分割成两个数组
        for (int i=0;i<array.length;i++){
            int count1=count;
           int num=array[i];
            int num3;
                while(num!=0){
                    if (count1==1){
                        if (num%2==1){
                            list.add(array[i]);
                        }else{
                            list1.add(array[i]);
                        }
                    }
                    num/=2;
                    count1--;
                }
        }
        int result1=list.get(0);
        for (int i=1;i<list.size();i++){
            result1^=list.get(i);
        }
        num1[0]=result1;
        int result2=list1.get(0);
        for (int i=1;i<list1.size();i++){
            result2^=list1.get(i);
        }
        num2[0]=result2;
    }

}
