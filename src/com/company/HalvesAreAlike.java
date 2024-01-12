package com.company;

import java.util.ArrayList;
import java.util.Arrays;

class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        if (s.length() % 2 != 0) return false;

        String firstHalf = s.substring(0, (s.length() / 2));
        String secondHalf = s.substring((s.length() / 2));

        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int vowelsInHalves = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.contains(firstHalf.charAt(i))) vowelsInHalves++;
            if (vowels.contains(secondHalf.charAt(i))) vowelsInHalves--;
        }
        if (vowelsInHalves != 0) return false;
        return true;
    }
}
