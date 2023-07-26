package org.example.quiz;

/**
 * @Author: DiDi
 * @Description: 263. Ugly Number
 * @Data: 2023-07-26-21:17
 */
public class UglyNumber {

    /**
     * 丑数 就是只包含质因数 2、3 和 5 的正整数。
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     *
     * @param n
     * @return
     */
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while((n % 5) == 0) n /= 5;
        while((n % 3) == 0) n /= 3;
        return ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}
