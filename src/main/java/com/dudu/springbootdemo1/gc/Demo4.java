package com.dudu.springbootdemo1.gc;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2021/8/14 5:21 下午
 */
public class Demo4 {
    public static void main(String[] args) throws Exception {
        Thread.sleep(30000);
        while(true){
            loadData();
        }
    }
    public static void loadData() throws Exception{
        byte[] data =null;
        for (int i=0;i<50;i++){
            data = new byte[100*1024];
        }
        data =null;

        Thread.sleep(1000);
    }
}
