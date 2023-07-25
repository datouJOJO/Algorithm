
package org.example.quiz;

import java.math.BigDecimal;

/**
 * @author DiDi
 * @description 实现开方
 * @date 2023/7/4 14:10
 */
public class Sqrt {

    /**
     * 解法1
     * 牛顿迭代法： N(n+1) = (N(n) + (m / N(n))) / 2
     * 无限逼近结果
     *
     * @param number        待开方数字
     * @param precision     精度
     * @return              开方结果
     */
    private static double sort1(int number, int precision) {
        if (number < 0) {
            System.out.println("传值有误：" + number);
            return -1;
        }
        if (number == 0) {
            return 0;
        }
        double result = number / 2.0;
        double epsilon = Math.pow(10, -precision);
        while (abs(result * result - number) > epsilon) {
            result = (result + (number / result)) / 2.0;
        }
        // BigDecimal.ROUND_HALF_UP四舍五入
        BigDecimal bigDecimal = new BigDecimal(result).setScale(precision, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }

    /**
     * 解法2 二分法
     * 取左右边界 逐渐逼近
     * 没有精度 向上取整
     *
     * @param x 待开方数字
     * @return  开方结果
     */
    private static int sort2(int x) {
        if (x == 0 || x == 1) return x;
        long left = 1;
        long right = x / 2;
        while(left < right) {
            long mid = (right + left) / 2 + 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid == x) {
                return (int)mid;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }

    /**
     * 取绝对值
     *
     * @param num   待取绝对值的数字
     * @return      取完绝对值的结果
     */
    private static double abs(double num) {
        return num < 0 ? -num : num;
    }

    public static void main(String[] args) {
        System.out.println(sort1(2, 3));
        System.out.println(sort2(2));
    }
}
