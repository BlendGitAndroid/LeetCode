package com.example.javalib.offer;

/**
 * 看了这个题解，才知道用归并排序。
 * <p>
 * 因为归并排序是稳定性排序，所以能够计算逆序对。
 */
class Offer51 {

    public static void main(String[] args) {
        int[] array = {7, 5, 6, 4};
        System.out.println(new Offer51().reversePairs(array));
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] helper = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1, helper);
    }

    private int reversePairs(int[] nums, int left, int right, int[] helper) {
        if (left == right) {
            return 0;
        }
        int middle = (left + right) / 2;
        int leftPairs = reversePairs(nums, left, middle, helper);
        int rightPairs = reversePairs(nums, middle + 1, right, helper);
        if (nums[middle] <= nums[middle + 1]) { //若左边数组最大的数，都小于右边数组最小的数，就不用merger了，说明没有逆序对
            return leftPairs + rightPairs;
        }
        int crossPairs = mergerAndCount(nums, left, middle, right, helper);
        return leftPairs + rightPairs + crossPairs;
    }

    //本函数的前提条件是，左边的数组和右边的数组按照升序排序好的
    private int mergerAndCount(int[] nums, int left, int middle, int right, int[] helper) {
        for (int i = left; i <= right; i++) {   //用helper数组来保存原始的数组信息
            helper[i] = nums[i];
        }
        int i = left;   //左边的开始
        int j = middle + 1; //右边的开始

        int count = 0;

        for (int k = left; k <= right; k++) {   //把left赋值给k，循环right-left+1次，每次循环，都会给nums重新赋值
            if (i == middle + 1) {  //当i已经超过左边数组边界，则赋值j，并且j++
                nums[k] = helper[j];
                ++j;
            } else if (j == right + 1) {    //当j到达右边数组边界，则赋值i，并且i++
                nums[k] = helper[i];
                i++;
            } else if (helper[i] <= helper[j]) {    //如果左边小于等于右边，赋值i，就不是逆序对
                nums[k] = helper[i];
                i++;
            } else {    //若右边的大于左边的，则是逆序对，赋值j，并且进行逆序对的计算
                nums[k] = helper[j];
                j++;
                //当helper[i] > helper[j]的时候，说明左边数组从i到middle都比j大，个数为middle - i + 1
                count += middle - i + 1;
            }
        }
        return count;
    }

}
