package com.test.code.backtracking;

public class KnightsProblem {

    public static void main(String[] args) {

        int N = 4;
        int knightPos[] = {0, 0};
        int targetPos[] = {3, 2};
        int count = 0;
        boolean[][] visited = initMatrix(N);
        minStepToReachTarget(knightPos, targetPos, N, visited, count);
    }

    private static boolean minStepToReachTarget(int[] knightPos, int[] targetPos, int n, boolean[][] visited, int count) {


        int[] xMovement = {1, -1, 1, -1, 2, 2, -2, -2};
        int[] yMovement = {2, 2, -2, -2, 1, -1, 1, -1};

        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1]) {
            System.out.println(" Count " + count);
            return true;
        }

        for (int i = 0; i < 8; i++) {

            int newX = xMovement[i] + knightPos[0];
            int newY = yMovement[i] + knightPos[1];

            if (isValidPosition(newX, newY, n) && !visited[knightPos[0]][knightPos[1]]) {
                visited[knightPos[0]][knightPos[1]] = true;
                knightPos[0] = newX;
                knightPos[1] = newY;
                System.out.println(" newX " + newX + "\t" + "newY" + newY);
                count++;
                return minStepToReachTarget(knightPos, targetPos, n, visited, count);
            }

        }
        visited[knightPos[0]][knightPos[1]] = false;
        count--;
        return false;
    }

    private static boolean[][] initMatrix(int n) {
        boolean[][] visited = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        return visited;
    }

    private static boolean isValidPosition(int x, int y, int N) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

}
