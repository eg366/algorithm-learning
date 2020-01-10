package com.eg366.al.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @Author: zhangjunyu
 * @Date: 2020/1/10 15:09
 */
public class DateTime {

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().withMonth(2));

        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(15, 13, 01));

        System.out.println(LocalDateTime.now());

        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDateTime.now());
    }
}
