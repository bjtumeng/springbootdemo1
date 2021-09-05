package com.dudu.springbootdemo1.algorithm;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/9/24 8:10 下午
 */
public class Demo18 {

    public static void main(String[] args) {
        int[] a={2,3,3,5,5,8};
        int[] fx = fx(a);
        for (int i=0;i<fx.length;i++){
            System.out.print(fx[i]+" ");
        }
    }
    public static int[] fx(int [] a){
        int[] b=new int[a.length];
        int k=0;
        for (int i=0;i<a.length;i++){
            if (i+1!=a.length){
                if (a[i]!=a[i+1]){
                    b[k]=a[i];
                    k++;
                }
            }else{
                b[k]=a[i];
                k++;
            }
        }
        return b;
    }
}
