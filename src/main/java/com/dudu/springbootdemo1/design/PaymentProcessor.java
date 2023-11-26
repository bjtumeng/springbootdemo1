package com.dudu.springbootdemo1.design;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/7 7:00 下午
 */
public interface PaymentProcessor {
    /**
     * 节点处理
     *
     * @param context
     */
    void handle(Payment context);

}
