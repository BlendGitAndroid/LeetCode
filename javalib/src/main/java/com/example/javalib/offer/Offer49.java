package com.example.javalib.offer;

/**
 * 果然，暴力算法，超时了。还是动态规划，用控件换取时间。
 * <p>
 * 上面的方法之所以会超时，是因为我们把每个数都判断了一遍，不管这个数是不是丑数。但是本方法我们只计算丑数，从而大大提升了时间效率。
 * 缺点是需要开辟一个长度为 n 的数组来进行动态规划过程。具体思路如下：
 * <p>
 * 首先我们要发现，任何一个丑数，都是可以由其前面的某个丑数乘2，或乘3，或乘5得到。
 * 我们先建立一个长度为 n 的 dp 数组，dp[i] 表示第 i + 1 个丑数。
 * 然后我们设立三个变量：two, three, five，它们都代表 dp 数组中的索引。我们通过选取 dp[two] * 2, dp[three] * 3 和 dp[five] * 5 中
 * 的最小值来确定下一个丑数的值。
 * 当找到了下一个丑数后，假如这个丑数是由 two 得来的，我们就 ++ two；假如是由 three 得来的，我们就 ++ three；是由 five 得来的，我们
 * 就 ++ five。这样就可以保证每个丑数都会被找出来。
 */
class Offer49 {

    public static void main(String[] args) {
        System.out.println(new Offer49().nthUglyNumber2(10));
    }

    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int tmp = 2;
        while (n != 1) {
            int a = tmp;
            while (a % 2 == 0 || a % 3 == 0 || a % 5 == 0) {
                if (a % 2 == 0) {
                    a = a / 2;
                } else if (a % 3 == 0) {
                    a = a / 3;
                } else {
                    a = a / 5;
                }
            }
            if (a == 1) {
                n--;
            }
            tmp++;
        }
        return --tmp;
    }

    public int nthUglyNumber2(int n) {
        int two = 0;
        int three = 0;
        int five = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int t1 = nums[two] * 2;
            int t2 = nums[three] * 3;
            int t3 = nums[five] * 5;
            int res = Math.min(Math.min(t1, t2), t3);
            //在这里，我用的是三个连续的if-else判断，结果导致出现重复的数6，为了避免重复，应该对每一个都进行判断
            if (res == t1) {
                two++;
            }
            if (res == t2) {
                three++;
            }
            if (res == t3) {
                five++;
            }
            nums[i] = res;
            System.out.println(i + "-- " + nums[i]);
        }
        return nums[n - 1];
    }
}
