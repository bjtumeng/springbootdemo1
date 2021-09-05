package com.dudu.springbootdemo1.algorithm;

import java.util.HashSet;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2020/11/22 9:33 下午
 */
public class Demo26 {
    public static void main(String[] args) {
        User user=new User();
        user.setAge(11);
        HashSet<User> hashSet=new HashSet<>();
        hashSet.add(user);
        user.setAge(12);
        hashSet.add(user);
        System.out.println(hashSet.size());

    }
}
