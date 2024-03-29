package com.dudu.springbootdemo1.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/1/9 6:14 下午
 */
@Data
public class OrderDTO {

    @ExcelIgnore
    private Long id;

    @ExcelProperty(value = "订单号", order = 1)
    private String orderId;
    @ExcelProperty(value = "金额", order = 2)
    private BigDecimal amount;
    @ExcelProperty(value = "支付时间", order = 3)
    private String paymentTime;
    @ExcelProperty(value = "订单状态", order = 4)
    private String orderStatus;
}
