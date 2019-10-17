package com.test.code.arrays;


/*
Input : Sorted Array
Input : Value :
Return : Count of Pairs greater than the input Value
 */
public class FindPair {

    public static void main(String[] args) {

        int[] array = {-1, 0, 1, 3, 5, 6};
        int sumValue = 5;

        int count = findPair(array, sumValue);
        System.out.println(count);
    }

    private static int findPair(int[] array, int sumValue) {
        int j = array.length - 1;
        int count = 0;

        while (j >= 0) {
            int number = array[j];
            int diff = sumValue - number;
            int index = findfirstIndexGreaterThan(diff, array, j);
            if (index != -1) {
                count = count + j - index;
            }
            j--;
        }
        return count;
    }

    private static int findfirstIndexGreaterThan(int diff, int[] array, int j) {
        for (int i = 0; i < j; i++) {
            int value = array[i];
            if (value > diff) {
                return i;
            }
        }
        return -1;
    }

}
