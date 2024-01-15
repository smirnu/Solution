package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        if (matches.length == 0) return result;

        HashMap<Integer, int[]> keepWinLose = new HashMap<>();
        int numberOfGamers = 0;
        for (int i = 0; i < matches.length; i++) {

            if (numberOfGamers < matches[i][0]) numberOfGamers = matches[i][0];
            if (numberOfGamers < matches[i][1]) numberOfGamers = matches[i][1];
            // adding the win game
            if (keepWinLose.get(matches[i][0]) == null) {
                keepWinLose.put(matches[i][0], new int[] {1, 0});
            } else {
                int[] tmp = keepWinLose.get(matches[i][0]);
                tmp[0]++;
                keepWinLose.put(matches[i][0], tmp);
            }
            // adding the lose game
            if (keepWinLose.get(matches[i][1]) == null) {
                keepWinLose.put(matches[i][1], new int[] {0, 1});
            } else {
                int[] tmp = keepWinLose.get(matches[i][1]);
                tmp[1]++;
                keepWinLose.put(matches[i][1], tmp);
            }
        }
        ArrayList<Integer> notLost = new ArrayList<>();
        ArrayList<Integer> lostExactOne= new ArrayList<>();

        for (int i = 1; i <= numberOfGamers; i++) {
            if (keepWinLose.get(i) != null) {
                int[] tmp = keepWinLose.get(i);
                if (tmp[1] == 0) notLost.add(i);
                else if (tmp[1] == 1) lostExactOne.add(i);
            }
        }

        result.add(notLost);
        result.add(lostExactOne);
        return result;
    }
}
