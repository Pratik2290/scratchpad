package com.test.code.arrays;


/*
Input : Sorted Array
Input : Value :
Return : Count of Pairs greater than the input Value
 */
public class FindPair {

    public static void main(String[] args) {

        int[] array = {-1, 0, 1, 3, 5, 6};
        int sumValue = 2;

        int count = findPair(array, sumValue);
        System.out.println(count);
    }

    private static int findPair(int[] array, int sumValue) {
        int i = 0;
        int j = array.length - 1;
        int count = 0;

        while (i <= j) {
            int smaller = array[i];
            int greater = array[j];

            int sum = smaller + greater;

            if (sum < sumValue) {
                int x = i;
                while (x < j) {
                    if (sum < sumValue) {
                        x++;
                        sum = smaller + array[x];
                    }
                }
                count = count + x - i;
                i++;
            } else if (sum > sumValue) {
                int x = i;
                x++;
                while (sum > sumValue && x < j) {
                    count++;
                    x++;
                    sum = greater + array[x];
                }
                j--;
            } else {
                i++;
                j--;
            }
        }
        return count;
    }

}
