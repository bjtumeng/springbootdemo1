//package com.dudu.springbootdemo1.config.db;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * @Description:
// * @author:zhaomeng
// * @date:2023/11/16 5:49 下午
// */
//
//@Configuration
//public class DataSourceConfig {
//
//    @ConfigurationProperties(prefix = "spring.datasource.druid")
//    @Bean
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }
//}