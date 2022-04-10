package com.demo.sort;

import java.util.Arrays;

public class ShellSort {


    public static void main(String[] args) {

        int[] arr = {5, 7, 2, 3, 1, 4};
        int[] arr2 = {5, 7, 2, 3, 1, 4};

//        int[] desc = desc(arr2);
        int[] asc = asc(arr);

        int[] ints = insertSort(arr2);
        System.out.println(Arrays.toString(ints));
        // 升序
        System.out.println(Arrays.toString(asc));
        // 降序
//        System.out.println(Arrays.toString(desc));
    }


    public static int[] asc(int[] arr) {
        //分块处理
        int gap = arr.length / 2; //增量
        while (1 <= gap) {
            //插入排序：只不过是与增量位交换
            for (int i = gap; i < arr.length; i++) {
                int key = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > key) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = key;
            }
            gap = gap / 2;
        }
        return arr;
    }


    public static int[] shellSort(int[] arr) {
        int length = arr.length;
        int gap = length / 2;
        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap /= 2;
        }

        return arr;


    }



    public static int [] insertSort(int [] arr){
        int length = arr.length;
        for (int i = 1 ; i < length ; i ++){
            int temp = arr[i];
            int j = i - 1;
            while ( j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j -- ;
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
