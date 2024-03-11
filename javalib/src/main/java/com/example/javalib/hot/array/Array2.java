package com.example.javalib.hot.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Array2 {

    public int[][] merge(int[][] a) {

        List<int[]> res = new ArrayList<>();

        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        int l = a[0][0], r = a[0][1];

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > r) {  // 如过当前数组的左边大于上一个数组的右边,说明是独立的
                res.add(new int[]{l, r});
                l = a[i][0];    // 左边等于当前数组
                r = a[i][1];    // 当前数组的右边
            } else {
                r = Math.max(r, a[i][1]);   // 否则,数组的右边为这两个数组
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[0][]);
    }

}
