package com.demo.sort;

public class TestRecursion {

    private static int sum = 0;

    public static void main(String[] args) {
//        int recursion = recursion(6);
//        System.out.println(recursion);
        test(3);
        System.out.println(sum);
    }


    public static int recursion(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return recursion(num - 1) + recursion(num - 2);
    }


    public static void test(int num) {
        if (num < 0)
            return;
        test(num - 1);
        sum += num;
    }


}
