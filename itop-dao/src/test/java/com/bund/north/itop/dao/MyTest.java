package com.bund.north.itop.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MyTest {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.dir"));

        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
    }
}
