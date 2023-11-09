package com.company;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class NextThread implements Comparable<NextThread> {
    public int number;
    public long startingTime;

    public NextThread(int number, long startingTime) {
        this.number = number;
        this.startingTime = startingTime;
    }

    @Override
    public int compareTo(NextThread thread) {
        if(this.startingTime > thread.startingTime) {
            return 1;
        } else if (this.startingTime < thread.startingTime) {
            return -1;
        } else {
            if(this.number > thread.number) {
                return 1;
            } else if (this.number < thread.number) {
                return -1;
            } else
                return 0;
        }
    }

}
public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];

        PriorityQueue<NextThread> whoIsNext = new PriorityQueue<>();
        for (int i = 0; i < numWorkers; i++) {
            whoIsNext.add(new NextThread(i, 0));
        }

        for (int i = 0; i < jobs.length; i++) {
            NextThread working = whoIsNext.remove();
            startTime[i] = working.startingTime;
            assignedWorker[i] = working.number;

            whoIsNext.add(new NextThread(working.number, working.startingTime + jobs[i]));
        }
//        long[] nextFreeTime = new long[numWorkers];
//        for (int i = 0; i < jobs.length; i++) {
//            int duration = jobs[i];
//            int bestWorker = 0;
//            for (int j = 0; j < numWorkers; ++j) {
//                if (nextFreeTime[j] < nextFreeTime[bestWorker])
//                    bestWorker = j;
//            }
//            assignedWorker[i] = bestWorker;
//            startTime[i] = nextFreeTime[bestWorker];
//            nextFreeTime[bestWorker] += duration;
//        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
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
