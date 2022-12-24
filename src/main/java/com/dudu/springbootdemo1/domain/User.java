package com.dudu.springbootdemo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2022/12/24 8:31 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer uid;
    private String username;
    private String pwd;
}
