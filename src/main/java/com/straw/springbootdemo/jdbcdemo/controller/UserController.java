package com.straw.springbootdemo.jdbcdemo.controller;

import com.straw.springbootdemo.jdbcdemo.entity.UserEntity;
import com.straw.springbootdemo.jdbcdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ Author : straw
 * @ Date   : 2019/11/21 18:33
 * @ Desc   :
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/add")
    public int add(UserEntity user) {
        return userService.add(user);
    }

    @GetMapping("/update")
    public int update(UserEntity user) {
        return userService.update(user);
    }

    @GetMapping("/delete")
    public int deleteById(String id) {
        return userService.deleteById(id);
    }

    @GetMapping("/getOne")
    public UserEntity getUserById(String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/find")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }
}
