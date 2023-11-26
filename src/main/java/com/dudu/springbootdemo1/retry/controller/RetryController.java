package com.dudu.springbootdemo1.retry.controller;

import com.dudu.springbootdemo1.retry.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/3 4:03 下午
 */
@RestController
@RequestMapping("/retry")
public class RetryController {
    @Autowired
    private RetryService retryService;

    @GetMapping("/test")
    @ResponseBody
    private void demo(int code) throws Exception {
         retryService.test(code);
    }


}
