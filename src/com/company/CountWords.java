/*
Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.
 */
package com.company;

import java.util.HashMap;

public class CountWords {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();

        for (String word : words1) {
            if (hm1.containsKey(word)) hm1.put(word, hm1.get(word) + 1);
            else hm1.put(word, 1);
        }

        for (String word : words2) {
            if (hm2.containsKey(word)) hm2.put(word, hm2.get(word) + 1);
            else hm2.put(word, 1);
        }

        int result = 0;

        for (String key : hm1.keySet()) {
            if (hm2.containsKey(key)) {
                if (hm1.get(key) == 1 && hm2.get(key) == 1) result++;
            }
        }
        return result;
    }
}
