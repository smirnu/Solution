package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
                opening_brackets_stack.add(new Bracket(next, position + 1));
            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (opening_brackets_stack.isEmpty()) {
                    opening_brackets_stack.add(new Bracket(next, position + 1));
                    break;
                } else if (!opening_brackets_stack.get(opening_brackets_stack.size() - 1).Match(next)) {
                    opening_brackets_stack.add(new Bracket(next, position + 1));
                    break;
                } else opening_brackets_stack.remove(opening_brackets_stack.size() - 1);
            }
        }

        // Printing answer, write your code here
        if (!opening_brackets_stack.isEmpty()) {
            System.out.println(opening_brackets_stack.get(opening_brackets_stack.size() - 1).position);
        } else System.out.println("Success");
    }
}
