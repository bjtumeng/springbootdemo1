package com.dudu.springbootdemo1.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        List<String> lists2 = new ArrayList<>();
        lists2.add("2");
        lists2.add("3");
        List<String> collect = lists.stream().skip(1).collect(Collectors.toList());
    }


}
