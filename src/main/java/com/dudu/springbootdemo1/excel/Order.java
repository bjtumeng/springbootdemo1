package com.dudu.springbootdemo1.excel;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/1/9 6:19 下午
 */
@Data
public class Order {
    private long id;
    private String creator;
    private String editor;
    private OffsetDateTime createTime;
    private OffsetDateTime editTime;
    private long version;
    private Integer deleted;
    private String orderId;
    private BigDecimal amount;
    private OffsetDateTime paymentTime;
    private Integer orderStatus;
}
