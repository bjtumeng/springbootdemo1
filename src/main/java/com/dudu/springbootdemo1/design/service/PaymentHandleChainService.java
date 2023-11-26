package com.dudu.springbootdemo1.design.service;

import com.dudu.springbootdemo1.design.Payment;
import com.dudu.springbootdemo1.design.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/7 7:02 下午
 */
@Service
public class PaymentHandleChainService {
    @Autowired
    private List<PaymentProcessor> paymentProcessors;

    public void execute(Payment payment) {
        for (PaymentProcessor paymentProcessor : paymentProcessors) {
            paymentProcessor.handle(payment);
        }
    }
}
