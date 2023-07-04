
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
    }
}
