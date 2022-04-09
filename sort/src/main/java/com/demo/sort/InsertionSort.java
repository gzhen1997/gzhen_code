package com.demo.sort;

import java.util.Arrays;

/**
 *
 * 插入福排序
 */
public class InsertionSort {


    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 1, 4};
        int[] arr2 = {5, 7, 2, 3, 1, 4};
        int[] asc = asc(arr);
        int[] desc = desc(arr2);
        System.out.println(Arrays.toString(asc));
        System.out.println(Arrays.toString(desc));

    }


    public static int[] asc(int[] arr){
        //从第二个数开始，把每个数依次插入到指定的位置
        for(int i = 1 ; i < arr.length ; i++)
        {
            int key = arr[i];
            int j = i-1;
            //大的后移操作
            while(j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }


        return arr;

    }


    public static int[] desc(int[] arr){
        //从第二个数开始，把每个数依次插入到指定的位置
        for(int i = 1 ; i < arr.length ; i++)
        {
            int key = arr[i];
            int j = i-1;
            //大的后移操作
            while(j >= 0 && arr[j] < key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }


        return arr;

    }



}
