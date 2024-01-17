package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> countingOccurence = new HashMap<>();
        HashSet<Integer> checkingUniqueOcc = new HashSet<>();

        for (int num: arr) {
            if (countingOccurence.keySet().contains(num)) countingOccurence.put(num, countingOccurence.get(num) + 1);
            else countingOccurence.put(num, 1);
        }

        for (int key: countingOccurence.keySet()) {
            if (checkingUniqueOcc.contains(countingOccurence.get(key))) return false;

            checkingUniqueOcc.add(countingOccurence.get(key));
        }
        return true;
    }
}
