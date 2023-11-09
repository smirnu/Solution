package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private void generateSwaps() {
        swaps = new ArrayList<Swap>();
        int n = data.length;
      // The following naive implementation just sorts 
      // the given sequence using selection sort algorithm
      // and saves the resulting sequence of swaps.
      // This turns the given array into a heap, 
      // but in the worst case gives a quadratic number of swaps.
      //
      // TODO: replace by a more efficient implementation
        if (n <= 1) return;

        int heightHeap = (int)(Math.log(n) / Math.log(2));
        int nodeInRow = (int) Math.pow(2, heightHeap);
        int indexFirst = nodeInRow - 1;

        while (nodeInRow > 1) {
            for (int i = indexFirst; i < Math.min(indexFirst + nodeInRow, n); i++) {
                int parent = (i - 1) / 2;
                int smallest = i;
                if (i + 1 < Math.min(indexFirst + nodeInRow, n) && data[i + 1] < data[smallest]) smallest = i + 1;

                if (data[smallest] < data[parent]) {
                    swaps.add(new Swap(parent, smallest));

                    //change places in the array
                    int tmp = data[parent];
                    data[parent] = data[smallest];
                    data[smallest] = tmp;
                    //siftDown
                    siftDown(smallest);
                }
                i++;
            }
            nodeInRow /= 2;
            indexFirst -= nodeInRow;
        }

    }
    private void siftDown(int nodeGoesDown) {
        if (nodeGoesDown > data.length) return;
        int left = nodeGoesDown * 2 + 1;
        int right = nodeGoesDown * 2 + 2;
        int n = data.length;
        int smallest = left;
        if (left < n) {
            if (right < n && data[right] < data[smallest]) smallest = right;
            if (data[smallest] < data[nodeGoesDown]) {
                swaps.add(new Swap(nodeGoesDown, smallest));

                //change places in the array
                int tmp = data[nodeGoesDown];
                data[nodeGoesDown] = data[smallest];
                data[smallest] = tmp;
                //siftDown
                siftDown(smallest);
            }
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
