package com.example.javalib.offer;

/**
 * 这道题，我是一点思路都没有，只能看答案。
 * 贪婪算法
 */
class Offer14 {

    public static void main(String[] args) {
        System.out.println(new Offer14().cuttingRope2(5));
    }

    /**
     * 观察可以发现，当n>=5时，我们应该尽可能多地剪出长度为3的绳子，这样会让乘积最大。
     * 除了当绳子的长度为4时，我们不用剪出长度为3的绳子，因为3x1 < 2x2，我们应该剪出长度为2的。
     * 所以可以用绳长n % 3(n >= 4，n=1,2,3拿出来做特例单独return)，那么情况就会有三种：n % 3 = 0或1或2。
     * =0，说明n可以整除3，直接return pow(3, n / 3);
     * =1，说明应该把多出来的这个1，和最后一个3拼在一起形成一个4，然后剪一个2x2出来，再与前面的相乘，即return pow(3, (n/3)-1) * 4;
     * =2，说明最后多出来一个2，直接用前面的结果乘2，即return pow(3, n/3) * 2;
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int count = n / 3;
        if (n % 3 == 0) {
            return (int) Math.pow(3, count);
        } else if (n % 3 == 1) {
            return (int) (Math.pow(3, count - 1) * 4);
        } else {
            return (int) (Math.pow(3, count) * 2);
        }
    }

    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        int res = 1;
        while (n > 4) {
            res = res * 3;
            n = n - 3;
        }
        //最后n的值只有可能是：2、3、4。而2、3、4能得到的最大乘积恰恰就是自身值
        return res * n;
    }

}
