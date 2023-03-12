package com.sanjin.test_debug;

import java.util.Arrays;

public class EvalueDebug {


    public static void main(String[] args) {
        int[] arr = new int[150];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }

        Arrays.stream(arr).forEach(vo -> {
            int a = vo;
            System.out.println(a);
        });
    }
}
