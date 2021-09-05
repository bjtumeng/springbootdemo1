package com.dudu.springbootdemo1.algorithm;

import java.util.HashMap;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/26 7:18 下午
 */
public class Demo19 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] a =new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int num=target-nums[i];
            //确保自己不能和自己相加
            if(map.containsKey(num)&&i!=map.get(num)){
                int value=map.get(num);
                a[0]=i;
                a[1]=value;
                return a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a={3,2,4};
        twoSum(a,6);
    }
}
