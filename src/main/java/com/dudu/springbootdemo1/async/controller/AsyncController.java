package com.dudu.springbootdemo1.async.controller;

import com.dudu.springbootdemo1.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description:学习Async使用方式
 * @author:zhaomeng
 * @date:2021/9/5 5:47 下午
 */
@Controller
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/test")
    @ResponseBody
    public String test() throws ExecutionException, InterruptedException {
        String s = null;
        Future<String> stringFuture = asyncService.test1();
        asyncService.test2();
        System.out.println("---------");
        String s1;
        while(true){
            if (stringFuture.isDone()){
                s1 = stringFuture.get();
                break;
            }
        }
        return s1;
    }
}
