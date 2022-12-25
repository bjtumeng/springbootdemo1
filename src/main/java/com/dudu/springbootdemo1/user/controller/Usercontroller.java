package com.dudu.springbootdemo1.user.controller;

import com.dudu.springbootdemo1.domain.User;
import com.dudu.springbootdemo1.domain.student.Student;
import com.dudu.springbootdemo1.user.servicce.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/23 9:26 上午
 */
@RestController
@RequestMapping("user")
@Slf4j
public class Usercontroller {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    private String add(String name){
        log.info("添加用户中,{}",name);
        return name;
    }
    @GetMapping("/diy")
    public String getInfo(){
        User user2 = userService.getUser2();
        System.out.println("信息为："+user2.getUsername());
        return "success";
    }
    @GetMapping("/query")
    public Student queryUser(){
        return userService.queryUser();
    }

    @GetMapping("/custom")
    public Student queryCustomUser(){
        return userService.queryCustomUser();
    }
}
