package com.company;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) return true;
        int count = nums.length - 1;
        while (count >= 0) {
            if (nums[count] == 0) {
                if (count == 0) return false;
                int stepsTillZero = 0;
                while (count > 0) {
                    count--;
                    stepsTillZero++;
                    if (count + stepsTillZero == nums.length - 1) {
                        stepsTillZero = 0;
                        break;
                    } else if (nums[count] > stepsTillZero) {
                        stepsTillZero = 0;
                        break;
                    }
                }
                if (stepsTillZero > 0) return false;
            } else count--;
        }
        return true;
    }
}
