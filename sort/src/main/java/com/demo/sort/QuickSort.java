package com.demo.sort;

import java.util.Arrays;

/**
 * @auther gz
 * @date 2022-04-12  22:22
 * @description 快速排序
 * <p>
 * 速排序的工作原理是：从待排序数组中随便挑选一个数字作为基准数，把所有比它小的数字放在它的左边，所有比它大的数字放在它的右边。然后再对它左边的数组和右边的数组递归进行这样的操作。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 7, 2, 3, 5, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int start = left, end = right;
        int temp = arr[left];

        while (start != end) {
            while (start < end && arr[end] >= temp) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= temp) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        quickSort(arr, left, start - 1);
        quickSort(arr, start + 1, right);

    }
}
