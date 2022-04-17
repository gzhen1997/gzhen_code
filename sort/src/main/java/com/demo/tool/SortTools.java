package com.demo.tool;

/**
 * @auther gz
 * @date 2022-04-13  20:47
 * @description
 */
public class SortTools {

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
