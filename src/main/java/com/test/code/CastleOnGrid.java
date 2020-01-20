package com.test.code;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CastleOnGrid {

    private static Integer minMoves = Integer.MAX_VALUE;

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int rowLength = grid.length;
        int columnLength = grid[0].length();

        int steps = 0;


        boolean[][] visited = new boolean[rowLength][columnLength];
        initVisited(visited, rowLength, columnLength);

        char[][] charMatrix = new char[rowLength][columnLength];

        initCharMatrix(charMatrix, rowLength, columnLength, grid);
        minimumMoves(charMatrix, startX, startY, goalX, goalY, steps, visited);
        return minMoves;
    }

    static void minimumMoves(char[][] charMatrix, int i, int j, int goalX, int goalY, int steps, boolean[][] visited) {

        if (isValid(charMatrix, visited, i, j)) {
            steps = steps + 1;
            if (i == goalX && j == goalY) {
                if (steps < minMoves) {
                    minMoves = steps/2;
                }
                return;
            }
            visited[i][j] = true;
            minimumMoves(charMatrix, i + 1, j, goalX, goalY, steps, visited);
            minimumMoves(charMatrix, i, j + 1, goalX, goalY, steps, visited);
            minimumMoves(charMatrix, i - 1, j, goalX, goalY, steps, visited);
            minimumMoves(charMatrix, i, j - 1, goalX, goalY, steps, visited);
            visited[i][j] = false;
            steps = steps - 1;
            return;
        }
    }

    static boolean isValid(char[][] charMatrix, boolean[][] visited, int i, int j) {
        int rowLength = charMatrix.length;
        int columnLength = charMatrix[0].length;
        return i >= 0 && i < rowLength && j >= 0 && j < columnLength
                && charMatrix[i][j] == '.' && !visited[i][j];
    }

    static void initVisited(boolean[][] visited, int rowLength, int columnLength) {
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                visited[i][j] = false;
            }
        }
    }

    static void initCharMatrix(char[][] charMatrix, int rowLength, int columnLength,
                               String[] strings) {
        for (int i = 0; i < rowLength; i++) {
            String str = strings[i];
            for (int j = 0; j < columnLength; j++) {
                charMatrix[i][j] = str.charAt(j);
            }
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int startX = 0;

        int startY = 0;

        int goalX = 0;

        int goalY = 2;

        List<String> list = new ArrayList<>();
        list.add(".X.");
        list.add(".X.");
        list.add("...");

        int result = minimumMoves(list.toArray(new String[0]), startX, startY, goalX, goalY);
        System.out.println(result);
    }
}

