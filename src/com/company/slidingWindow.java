//package com.company;

import java.util.*;
import java.io.*;

public class slidingWindow {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] allElements = new int[n];

        for (int i = 0; i < n; ++i) {
            int number = scanner.nextInt();
            allElements[i] = number;
        }
        int m = scanner.nextInt();

        LinkedList<Integer> queueOfM = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!queueOfM.isEmpty() && queueOfM.get(queueOfM.size() - 1) < allElements[i]) queueOfM.remove(queueOfM.size() - 1);

            queueOfM.add(allElements[i]);
            if (i >= m && queueOfM.size() > 1 && queueOfM.get(0) == allElements[i - m]) queueOfM.remove(0);
            if (i + 1 >= m) System.out.print(queueOfM.get(0) + " ");
        }
    }

    static public void main(String[] args) throws IOException {
        new slidingWindow().solve();
    }
}
