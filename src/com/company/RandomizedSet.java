package com.company;

import java.util.HashSet;
import java.util.Set;

class RandomizedSet {

    private Set<Integer> randSet;

    public RandomizedSet() {
        randSet = new HashSet<>();
    }

    public boolean insert(int val) {

        return randSet.add(val);
    }

    public boolean remove(int val) {
        return randSet.remove(val);
    }

    public int getRandom() {
        int random = (int)(Math.random() * randSet.size());
        int i = 0;
        for (int el: randSet) {
            if (i == random) return el;
            i++;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
