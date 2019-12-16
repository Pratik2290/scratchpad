package com.test.code.arrays;

import java.util.Arrays;

public class ArrayPairMultpilcation {


    static long solve(int[] arr) {

        Long result = 0l;
        Arrays.sort(arr);
        int maxValue = arr[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            int divisor = maxValue / arr[i];
            int lastIndex = getLastIndex(arr, divisor,i);
            if(lastIndex != -1){
                int sum = lastIndex - i;
                result = result + Long.valueOf(sum);
            }
        }
        return result;
    }

    private static int getLastIndex(int[] arr, int divisor, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            int value = arr[i];
            if (value <= divisor) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {100, 100, 100, 1};
        System.out.println(solve(array));
    }
}
