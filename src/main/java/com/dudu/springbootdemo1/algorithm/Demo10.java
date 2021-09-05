package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:二分查找
 * @author:zhaomeng
 * @date:2020/8/31 9:49 下午
 */
public class Demo10 {
    public static int search(int[] nums, int target) {
       int low=0;
       int high=nums.length-1;
       while(low<high){
           int mid=(low+high)/2;
           if (mid>target){
               high=mid-1;
           }else if (mid<target){
               low=mid+1;
           }else {
               return mid;
           }
       }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums={-1,0,3,5,9,12};
        int target=9;
        System.out.println(search(nums,target));
    }
}
