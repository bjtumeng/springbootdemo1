package com.dudu.springbootdemo1.excel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Driver;
import java.util.Random;
import java.util.UUID;

/**
 * @Description: 模拟写入200万数据
 * @author:zhaomeng
 * @date:2022/1/9 5:53 下午
 */
public class OrderServiceTest {

    private static final Random OR = new Random();
    private static final Random AR = new Random();
    private static final Random DR = new Random();

    @Test
    public void testGenerateTestOrderSql() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setUsername("root");
        config.setPassword("root");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false");
        config.setDriverClassName("com.mysql.jdbc.Driver");
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(hikariDataSource);
        for (int d = 0; d < 100; d++) {
            String item = "('%s','%d','2020-07-%d 00:00:00','%d')";
            StringBuilder sql = new StringBuilder("INSERT INTO t_order(order_id,amount,payment_time,order_status) VALUES ");
            for (int i = 0; i < 20_000; i++) {
                sql.append(String.format(item, UUID.randomUUID().toString().replace("-", ""),
                        AR.nextInt(100000) + 1, DR.nextInt(31) + 1, OR.nextInt(3))).append(",");
            }
            jdbcTemplate.update(sql.substring(0, sql.lastIndexOf(",")));
        }
        hikariDataSource.close();
    }
}
