package com.example.javalib.hot.binary_search;

class Search4 {

    // 分段二分查找，就是这个边界值，什么时候该用>=还是>，类似于这样的
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 如果是有序的
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {   // 这里应该是target >= nums[left]
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 如果右半边是有序的
                if (target > nums[mid] && target <= nums[right]) {  // 这里应该是target <= nums[right]
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
