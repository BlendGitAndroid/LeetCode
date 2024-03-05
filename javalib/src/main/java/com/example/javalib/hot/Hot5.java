package com.example.javalib.hot;

class Hot5 {

    public static void main(String[] args) {
        // int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] heights = {1, 1};
        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);
            maxArea = Math.max(width * height, maxArea);
            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }

}
