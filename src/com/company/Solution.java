package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String toGoatLatin(String S) {
        String[] strInArray = S.split(" ");
        List<Character> vowels = Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});

        StringBuilder result = new StringBuilder();

        StringBuilder ending = new StringBuilder("maa");
        for (String str : strInArray) {
            if (vowels.contains(str.charAt(0))) {
                result.append(str + ending + " ");
            } else {
                result.append(str.substring(1, str.length()) + str.charAt(0) + ending + " ");
            }
            ending.append('a');
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
}
