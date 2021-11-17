package com.wy.newFeature;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {

        List<String> collect = Stream.of("a", "b", "c")
                .map(s -> s.toUpperCase()) // 惰性求值
                .collect(Collectors.toList()); // 及时求值
        System.out.println(collect);

        // 当天的日期
        LocalDate localDate = LocalDate.now();
        // 当月的第多少天
        int dayOfMonth = localDate.getDayOfMonth();

        String type = String.format("u%d", localDate.getDayOfMonth());

        String format = String.format("u%d", localDate.lengthOfMonth());


        int dayOfYear = localDate.getDayOfYear();
        Month month = localDate.getMonth();
        int value = month.getValue();
        // 本月的第一天
        LocalDate firstday = LocalDate.of(localDate.getYear(),localDate.getMonth(),1);
        // 输出本月第一天，在一年中的多少年   可以作为offset偏移量
        System.out.println(firstday.getDayOfYear());
        System.out.println(value);
        System.out.println(dayOfYear);
        // 打印天数
        System.out.println(dayOfMonth);
        System.out.printf(type);

        Date date = new Date();
        String s = date.toString();
        System.out.println(s);
    }
}
