package com.test.code;

public class RowWithMax1 {

    public static void main(String[] args) {

        Integer[][] matrix = {{0, 0, 0, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}};
        int rowNumber = findRow(matrix);
        System.out.println(rowNumber);

    }

    private static int findRow(Integer[][] matrix) {

        int rowNumber = 1;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        Integer[] firstRow = matrix[0];
        int colIndex = colCount - 1;
        for (int j = colCount - 1; j >= 0; j--) {
            if (firstRow[j] == 0) {
                break;
            }
            colIndex = j;
        }
        if (colIndex == 0) {
            return rowNumber;
        }

        for (int i = 1; i < rowCount; i++) {
            while (colIndex >= 0 && matrix[i][colIndex] == 1) {
                colIndex--;
                rowNumber = i + 1;
            }
        }
        return rowNumber;
    }
}
