package com.straw.springbootdemo.jdbcdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author : straw
 * @ Date   : 2019/11/21 17:40
 * @ Desc   :
 */

@Data
@NoArgsConstructor
public class UserEntity {

    private int id;
    /**
     *用户名
     */
    private String name;
    /**
     *密码
     */
    private String pwd;

}
