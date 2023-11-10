package com.example.javalib.offer;

/**
 * 这道题考虑了很久，也不要忘记最后有个减去'0'的过程
 * <p>
 * 关键还是先找到位数，再找到起始数，最后使用除法找到这个数是多少，再取余找出这个数是第几位，从而得到结果。
 * <p>
 * 我第一次运行失败，原因是都是用的是int，又来改成long才通过，原因是当测试数据为1000000000时，start和indexCount
 * 会超过int的范围。
 */
class Offer44 {

    public static void main(String[] args) {
        System.out.println(new Offer44().findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }

        int digit = 1;  //位数
        long start = 1;  //起始数
        long indexCount = digit * 9 * start; //该位一共有多少个数
        while (n > indexCount) {
            //找出n属于哪个范围的索引
            n = (int) (n - indexCount); //这里采用n相减的方式
            digit++;
            start = start * 10;
            indexCount = digit * 9 * start;
        }
        // 上面的循环结束后：
        // digit 等于原始的 n 所属的数位；start 等于原始的 n 所属数位的数的起始点
        // index_count 等于原始的 n 所属数位的索引总个数（不重要了，下面不用）
        // n 等于在当前数位里的第 n - 1 个数（数从 0 开始算起）
        long num = start + (n - 1) / digit; //算出原始的N对应哪个数字，这里采用除法，算出应该对应的是哪个数
        int reminder = (n - 1) % digit; //余数就是原始的n是这个数字中的第几位，这里用位数取余，直接取到第几位
        String sNum = String.valueOf(num);
        return sNum.charAt(reminder) - '0';
    }

}
