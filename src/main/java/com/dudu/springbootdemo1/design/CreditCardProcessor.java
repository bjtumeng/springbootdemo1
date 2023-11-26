package com.dudu.springbootdemo1.design;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/7 7:01 下午
 */
@Order(1)
@Component
public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void handle(Payment context) {
        if(context.isSuccess()){
            System.out.println("Processed credit card payment.");
        }
    }
}