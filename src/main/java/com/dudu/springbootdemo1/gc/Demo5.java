package com.dudu.springbootdemo1.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/8/15 10:19 上午
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        List<Data> datas = new ArrayList<>();
        for (int i = 0; i < 10000 ; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1*60*60*1000);
    }
    static class Data{}
}
