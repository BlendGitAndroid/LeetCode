package com.example.javalib.hot.back_tracking;

import java.util.ArrayList;
import java.util.List;

class BackTracking1 {

    List<Integer> nums;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] array) {
        res = new ArrayList<>();
        nums = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            nums.add(array[i]);
        }
        dfs(0);
        return res;
    }

    private void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));
        }
        for (int i = x; i < nums.size(); i++) {
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);            // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }
    }

    private void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }

}
