package com.demo.sort;

import java.util.Arrays;

/**
 * @auther gz
 * @date 2022-04-12  22:22
 * @description 快速排序
 *
 * 速排序的工作原理是：从待排序数组中随便挑选一个数字作为基准数，把所有比它小的数字放在它的左边，所有比它大的数字放在它的右边。然后再对它左边的数组和右边的数组递归进行这样的操作。
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 1, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = arr[left];

        while (left != right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        quickSort(arr, 0, left - 1);
        quickSort(arr, left + 1, right);

    }
}
