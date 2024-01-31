package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> charToWord = new HashMap<>();
        HashSet<String> checkIfexisted = new HashSet<>();
        String[] splittedS = s.split(" ");
        if (pattern.length() != splittedS.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (charToWord.containsKey(pattern.charAt(i))) {
                if (!charToWord.get(pattern.charAt(i)).equals(splittedS[i])) return false;
            } else {
                if (!checkIfexisted.add(splittedS[i])) return false;
                charToWord.put(pattern.charAt(i), splittedS[i]);
            }
        }
        return true;
    }
}
