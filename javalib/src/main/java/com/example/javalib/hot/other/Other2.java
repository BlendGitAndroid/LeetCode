package com.example.javalib.hot.other;

class Other2 {

    public int majorityElement(int[] nums) {
        int val = 0;
        int index = 0;
        for (int num : nums) {
            if (index == 0) {
                val = num;
                index++;
            } else if (num == val) {
                index++;
            } else {
                index--;
            }
        }
        return val;
    }

}
