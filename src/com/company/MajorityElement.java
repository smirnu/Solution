package com.company;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int half = nums.length / 2;
        int count = 1;
        int compareWith = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (compareWith == nums[i]) {
                count++;
                if (count > half) return compareWith;
            } else {
                count = 1;
                compareWith = nums[i];
            }
        }
        return compareWith;
    }
}
