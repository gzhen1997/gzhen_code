package com.demo.sort;

import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 1, 4,452,234,234234,23,423,4,54,43,5,3,45,345,3,45,345,3,5,3,5,345,3,45,34,53,5};
        sortHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapify(int[] tree, int length, int idx) {
        if (idx >= length - 1) {
            return;
        }
        int max = idx;
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;
        if (leftChild < length && tree[max] < tree[leftChild]) {
            max = leftChild;
        }
        if (rightChild < length && tree[max] < tree[rightChild]) {
            max = rightChild;
        }
        if (max != idx) {
            swap(tree, idx, max);
            heapify(tree, length, max);
        }
    }


    public static void swap(int[] tree, int x, int y) {
        int temp = tree[x];
        tree[x] = tree[y];
        tree[y] = temp;
    }


    public static void buildHeap(int[] tree, int length) {
        int lastNode = length - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            heapify(tree, length, i);
        }
    }


    public static void sortHeap(int[] tree, int length) {
        buildHeap(tree, length);
        for (int i = length - 1; i > 0; i--) {
            swap(tree, i, 0);
            heapify(tree,i,0);
        }

    }
}
