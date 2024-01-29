package com.company;

import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        List<Character> allChars = new ArrayList();
        for (int i = 0; i < t.length(); i++) {
            allChars.add(t.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (allChars.contains(s.charAt(i))) {
                int index = allChars.indexOf(s.charAt(i));
                if (index != allChars.size() - 1) allChars = allChars.subList(allChars.indexOf(s.charAt(i)) + 1, allChars.size());
                else allChars = allChars.subList(0, 0);
            } else return false;
        }
        return true;
    }
}
