package com.dudu.springbootdemo1.design;

import com.dudu.springbootdemo1.Springbootdemo1Application;
import com.dudu.springbootdemo1.design.service.PaymentHandleChainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/7 7:03 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springbootdemo1Application.class)
public class PaymentServiceTest {
    @Autowired
    private PaymentHandleChainService paymentHandleChainService;

    @Test
    public void test() {
        paymentHandleChainService.execute(new Payment());
    }
}
