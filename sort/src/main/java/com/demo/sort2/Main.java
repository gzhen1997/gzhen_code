package com.demo.sort2;

import java.util.Arrays;

/**
 * @auther gz
 * @date 2022-04-13  20:50
 * @description
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,53,12,4};
//        BubblingSort.sort(arr);
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
