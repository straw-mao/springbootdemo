package com.straw.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: straw
 * desc: 读取配置文件中的值
 */

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Value("${test.num}")
    private String num;

    @GetMapping("/getNum")
    public String getNum() {

        return num;
    }

}
