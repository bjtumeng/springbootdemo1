package com.dudu.springbootdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableAsync
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.dudu.springbootdemo1.dao")
public class Springbootdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo1Application.class, args);
    }

}
