package com.test.code;

public class SnakeSequenceDP {


    private Integer[][] matrix = {{9, 6, 5, 2}, {8, 7, 6, 5}, {7, 3, 1, 6}, {1, 1, 1, 7}};
    private int rowMax = matrix.length;
    private int columnMax = matrix[0].length;
    private int maxLength = 0;


    public static void main(String[] args) {
        SnakeSequenceDP snakeSequenceDP = new SnakeSequenceDP();
        snakeSequenceDP.getMaxSequence();
    }

    private void getMaxSequence() {
        int currLength = 0;
        int i = 0;
        int j = 0;
        int currentValue = matrix[i][j];
        getMaxSequence(matrix, currentValue, i + 1, j, currLength);
        getMaxSequence(matrix, currentValue, i, j + 1, currLength);

        System.out.println(" Max Length " + maxLength);

    }

    private void getMaxSequence(Integer[][] matrix, int currentValue, int i, int j, int currLength) {
        if (isValid(i, j)) {
            int nextValue = matrix[i][j];
            if (Math.abs(currentValue - nextValue) == 1) {
                currLength++;
                if (i == rowMax - 1 && j == columnMax - 1) {
                    if (currLength > maxLength) {
                        maxLength = currLength;
                    }
                    return;
                }
                getMaxSequence(matrix, nextValue, i + 1, j, currLength);
                getMaxSequence(matrix, nextValue, i, j + 1, currLength);
            }
        }
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < rowMax && j >= 0 && j < columnMax;
    }
}
