package com.demo.sort2;

import com.demo.tool.SortTools;

/**
 * @auther gz
 * @date 2022-04-13  20:51
 * @description
 */
public class HeapSort {


    private static void heapify(int[] arr, int length, int rootIdx) {
        if (rootIdx >= length - 1) {
            return;
        }
        int parent = rootIdx;
        int leftChild = 2 * rootIdx + 1;
        int rightChild = 2 * rootIdx + 2;
        if (leftChild < length && arr[parent] < arr[leftChild]) {
            parent = leftChild;
        }
        if (rightChild < length && arr[parent] < arr[rightChild]) {
            parent = rightChild;
        }
        if (parent != rootIdx) {
            SortTools.swap(arr, parent, rootIdx);
            heapify(arr, length, parent);
        }
    }


    private static void buildHeap(int[] arr) {
        int length = arr.length;
        int lastNodeIdx = length / 2 - 1;
        for (int i = lastNodeIdx; i >= 0; i--) {
            heapify(arr, length, i);
        }
    }


    public static void sort(int[] arr) {
        int length = arr.length;
        buildHeap(arr);
        for (int i = length - 1; i > 0; i--) {
            SortTools.swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }


}
