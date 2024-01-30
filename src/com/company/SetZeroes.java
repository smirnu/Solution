package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<int[]> stackCoordsToZero = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (matrix[i][j] == 0) {
                    for (int y = 0; y < n; y++) {
                        if (j != y) stackCoordsToZero.add(new int[] {i, y});
                    }
                    for (int y = 0; y < m; y++) {
                        if (i != y) stackCoordsToZero.add(new int[] {y, j});
                    }
                }
            }
        }
        stackCoordsToZero.forEach((coords)->
            matrix[coords[0]][coords[1]] = 0);
    }
}
