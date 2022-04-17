package com.demo.sort2;

import com.demo.tool.SortTools;

/**
 * @auther gz
 * @date 2022-04-13  20:39
 * @description 冒泡排序
 */
public class BubblingSort {


    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortTools.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }
}
