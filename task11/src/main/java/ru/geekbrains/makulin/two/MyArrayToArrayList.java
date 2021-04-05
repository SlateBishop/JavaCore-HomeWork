package ru.geekbrains.makulin.two;

import java.util.Arrays;
import java.util.List;

public class MyArrayToArrayList<T> {

    public List<T> asList(T[] arr) {
        return Arrays.asList(arr);
    }

}
