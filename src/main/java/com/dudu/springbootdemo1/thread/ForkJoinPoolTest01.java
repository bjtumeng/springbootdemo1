package com.dudu.springbootdemo1.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/7/24 10:59 下午
 */
public class ForkJoinPoolTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int length =100000000;
        long[] arr =new long[length];
        for (int i = 0; i <length ; i++) {
            arr[i]= ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }
        singleThreadSum(arr);
        multiThreadSum(arr);
        forkJoinSum(arr);
    }
    private static void singleThreadSum(long[] arr){
        long start = System.currentTimeMillis();
        long sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i]/3*3/3*3/3*3/3*3/3*3/3*3;
        }
        long end =System.currentTimeMillis();
        System.out.println("结果:"+sum);
        System.out.println("单线程耗时："+(end-start));
    }
    private static void multiThreadSum(long[] arr) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Future<Long>> futures =new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int num = i;
            Future<Long> submit = executorService.submit(() -> {
                long sum = 0;
                for (int j = arr.length / 5 * num; j < (arr.length / 5 * (num + 1)); j++) {
                    sum += arr[j] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3;
                }
                return sum;
            });
            futures.add(submit);
        }
        long sum =0;
        for (Future<Long> future :futures){
            sum+=future.get();
        }
        System.out.println("结果:"+sum);
        long end =System.currentTimeMillis();
        System.out.println("线程池耗时："+(end-start));
    }

    private static void forkJoinSum(long[] arr) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool =ForkJoinPool.commonPool();
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new SumTask(arr, 0, arr.length));
        Long sum = forkJoinTask.get();
        forkJoinPool.shutdown();
        System.out.println("结果:"+sum);
        long end =System.currentTimeMillis();
        System.out.println("forkJoin耗时："+(end-start));
    }

}
