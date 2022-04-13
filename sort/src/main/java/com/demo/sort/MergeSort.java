package com.demo.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr2 = {5, 7, 2, 3, 1, 4};

        mergeSort(arr2, 0, arr2.length - 1);

        System.out.println(Arrays.toString(arr2));
    }


    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            //递归排序左边
            mergeSort(arr, low, middle);
            //递归排序右边
            mergeSort(arr, middle + 1, high);
            //将递归排序好的左右两边合并
            merge(arr, low, middle, high);

        }

    }

    public static void merge(int[] arr, int low, int middle, int high) {
        //存储归并后的临时数组
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = middle + 1;
        //记录临时数组中存放数字的下标
        int index = 0;
        while (i <= middle && j <= high) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        //处理剩下的数据
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        //将临时数组中的数据放回原来的数组
        for (int k = 0; k < temp.length; ++k) {
            arr[k + low] = temp[k];
        }
    }
}
