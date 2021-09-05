package com.dudu.springbootdemo1.thread;

import java.util.concurrent.RecursiveTask;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/7/25 9:39 上午
 */
public class SumTask extends RecursiveTask<Long> {
    private long[] arr;
    private int from;
    private int to;

    public SumTask(long[] arr, int from, int to) {
        this.arr = arr;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if (to - from <=1000){
            long sum=0;
            for (int i = from; i < to; i++) {
                sum += arr[i] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3;
            }
            return sum;
        }
        int mid =(from+to)/2;
        SumTask left =new SumTask(arr,from,mid);
        SumTask right =new SumTask(arr,mid,to);
        //提交左边任务
        left.fork();
        //右边任务利用当前线程计算
        Long rightResult = right.compute();
        //等待左边计算完毕
        Long leftResult = left.join();
        return rightResult+leftResult;
    }
}
