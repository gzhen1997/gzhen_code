package com.demo.sort;

import com.demo.type.SortEnum;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 1, 1, 4};
        int[] arr2 = {5, 7, 2, 3, 1, 4};

        int[] asc = asc(arr, SortEnum.ASC);
        int[] desc = asc(arr2, SortEnum.DESC);
        // 升序
        System.out.println(Arrays.toString(asc));
        // 降序
        System.out.println(Arrays.toString(desc));
    }


    public static int[] asc(int[] arr, SortEnum sortEnum) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (sort(arr[maxIdx], arr[j], sortEnum)) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                swap(arr, maxIdx, i);
            }

        }
        return arr;
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    public static boolean sort(int left, int right, SortEnum sortEnum) {
        switch (sortEnum) {
            case ASC:
                return left > right;
            case DESC:
                return left < right;
        }
        return false;

    }
}
