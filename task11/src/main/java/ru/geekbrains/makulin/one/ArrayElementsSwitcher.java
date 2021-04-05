package ru.geekbrains.makulin.one;

import java.util.Arrays;

public class ArrayElementsSwitcher {

    public <T> void switchElements (T[] arr, int i1, int i2) {
        T a = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = a;
    }

    public static void main(String[] args) {
        ArrayElementsSwitcher arrayElementsSwitcher = new ArrayElementsSwitcher();
        String[] arr = {"a", "b", "c", "d"};
        arrayElementsSwitcher.switchElements(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }
}
