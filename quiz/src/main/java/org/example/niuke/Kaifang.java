package org.example.niuke;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-23-0:02
 */
public class Kaifang {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        double res = number / 2;
        while(Math.abs(res * res - number) > 0.1) {
            res = (res + (number / res)) / 2.0;
        }
        // 设置精度
        BigDecimal decimal = new BigDecimal(res).setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal.doubleValue());
    }
}
