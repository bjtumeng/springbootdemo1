package com.dudu.springbootdemo1.design;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/7 7:02 下午
 */
@Order(2)
@Component
public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void handle(Payment context) {
        System.out.println("Processed PayPal payment.");

    }
}
