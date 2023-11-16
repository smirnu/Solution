package com.company;

import java.util.PriorityQueue;

public class KthLargestNumber {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> maxQueue = new PriorityQueue<>((a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());

        for (String num : nums) {
            maxQueue.add(num);
            if(maxQueue.size() > k) maxQueue.poll();
        }

        return maxQueue.poll();
    }
}
