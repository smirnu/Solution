package com.company;

public class RemoveDuplicates {
    public int[] removeDuplicates(int[] nums) {
        if (nums.length == 1) return nums;
        int left = 0;
        int repeat = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] == nums[i]) {
                repeat++;
                if (left > 0) nums[left] = nums[i];
                if (repeat < 3) {
                    left++;
                    nums[left] = nums[i];
                }
            } else {
                if (repeat < 2) left++;
                nums[left] = nums[i];
                repeat = 0;
            }
        }
        if (repeat < 2) left++;
        nums[left] = nums[nums.length - 1];
        return nums;
    }
}
