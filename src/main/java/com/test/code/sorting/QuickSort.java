package com.test.code.sorting;

public class QuickSort {


    public static void main(String[] args) {

        int[] array = {100, 50, 23, 9, 18, 61, 32, 1};
        quickSort(array);
        System.out.println(array);

    }

    private static void quickSort(int[] array) {
        int length = array.length;
        int lowIndex = 0;
        int highIndex = length - 1;

        quickSort(array, lowIndex, highIndex);

    }

    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivot = partition(array, lowIndex, highIndex);
            quickSort(array, lowIndex, pivot - 1);
            quickSort(array, pivot + 1, highIndex);
        }

    }

    private static int partition(int[] array, int start, int endIndex) {
        int pivotIndex = endIndex;
        int pIndex = start;

        while (start < endIndex) {
            if (array[start] < array[pivotIndex]) {
                swap(pIndex, start, array);
                pIndex++;
            }
            start++;
        }
        swap(pIndex, pivotIndex, array);
        return pIndex;
    }

    private static void swap(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
