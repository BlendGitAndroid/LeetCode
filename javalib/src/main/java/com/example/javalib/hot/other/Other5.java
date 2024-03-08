package com.example.javalib.hot.other;

class Other5 {

    // 我考,这个题和龟兔赛跑差不多啊
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // 快慢指针的相遇点
        do {
            slow = nums[slow];  // 每次走一步
            fast = nums[nums[fast]];    //每次都两步
        } while (slow != fast);

        // 找重合点
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
