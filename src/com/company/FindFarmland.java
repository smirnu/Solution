package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class FindFarmland {
    public int[][] findFarmland(int[][] land) {

        int first = land.length;
        int second = land[0]. length;
        boolean[][] visited = new boolean[first][second];
        ArrayList<int[]> resultInArray = new ArrayList<>();
        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {

                if (land[i][j] == 1 && !visited[i][j]) {
                    Stack<int[]> stack = new Stack<>();
                    int[] miniLand = new int[4];

                    stack.add(new int[] {i, j});
                    miniLand[0] = i;
                    miniLand[1] = j;
                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();
                        visited[cur[0]][cur[1]] = true;
                        if (cur[0] == first - 1) {
                            miniLand[2] = cur[0];
                        } else {
                            if (land[cur[0] + 1][cur[1]] == 1 && !visited[cur[0] + 1][cur[1]]) {
                                stack.push(new int[] {cur[0] + 1, cur[1]});
                            } else if (land[cur[0] + 1][cur[1]] == 0) {
                                miniLand[2] = cur[0];
                            }
                        }
                        if (cur[1] == second - 1) {
                            miniLand[3] = cur[1];
                        } else {
                            if (land[cur[0]][cur[1] + 1] == 1 && !visited[cur[0]][cur[1] + 1]) {
                                stack.push(new int[] {cur[0], cur[1] + 1});
                            } else if (land[cur[0]][cur[1] + 1] == 0) {
                                miniLand[3] = cur[1];
                            }
                        }
                    }
                    resultInArray.add(miniLand);
                }
            }
        }
        int[][] result = new int[resultInArray.size()][4];
        for (int i = 0; i < resultInArray.size(); i++) {
            result[i] = resultInArray.get(i);
        }
        return result;
    }
}
