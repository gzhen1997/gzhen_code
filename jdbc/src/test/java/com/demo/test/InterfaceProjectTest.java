package com.demo.test;

import org.junit.Test;

public class InterfaceProjectTest {


    @Test
    public void test(){

        System.out.println(testSum(5, 7, Integer::sum));
    }


    public int testSum(int x,int y,Action action){
        return action.sum(x,y);
    }
}
