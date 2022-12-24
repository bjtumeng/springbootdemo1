package com.dudu.springbootdemo1.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/1/9 6:14 下午
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public List<OrderDTO> queryByScrollingPagination(String paymentDateTimeStart,
                                                     String paymentDateTimeEnd,
                                                     long lastBatchMaxId,
                                                     int limit) {
        LocalDateTime start = LocalDateTime.parse(paymentDateTimeStart, F);
        LocalDateTime end = LocalDateTime.parse(paymentDateTimeEnd, F);
        return orderDao.queryByScrollingPagination(lastBatchMaxId, limit, start, end).stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setId(order.getId());
            dto.setAmount(order.getAmount());
            dto.setOrderId(order.getOrderId());
            dto.setPaymentTime(order.getPaymentTime().format(F));
//            dto.setOrderStatus(order.getOrderStatus());
            return dto;
        }).collect(Collectors.toList());
    }
}
