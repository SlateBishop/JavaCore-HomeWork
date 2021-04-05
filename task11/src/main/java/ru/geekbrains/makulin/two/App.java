package ru.geekbrains.makulin.two;

import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        MyArrayToArrayList<Long> longAsList = new MyArrayToArrayList<>();
        Long[] arr = {1L, 10000000L, 9999999999999L};
        List<Long> list = longAsList.asList(arr);
        System.out.println(list);
    }
}
