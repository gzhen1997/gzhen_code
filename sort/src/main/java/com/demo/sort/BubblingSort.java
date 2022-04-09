package com.demo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubblingSort {


    public static void main(String[] args) {

        int[] arr = {5, 7, 2, 3, 1, 4};
        int[] arr2 = {5, 7, 2, 3, 1, 4};

        int[] desc = desc(arr2);
        int[] asc = asc(arr);
        // 升序
        System.out.println(Arrays.toString(asc));
        // 降序
        System.out.println(Arrays.toString(desc));
    }


    public static int[] asc(int[] arr) {
        int length = arr.length;
        boolean flag;
        for (int i = 0; i < length - 1; i++) {
            flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return arr;
    }


    public static int[] desc(int[] arr) {
        int length = arr.length;
        boolean flag;
        for (int i = 0; i < length - 1; i++) {
            flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return arr;
    }


    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}
