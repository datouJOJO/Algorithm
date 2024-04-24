package org.example.niuke;

import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: 整数与IP地址之间的转换
 * @Data: 2024-04-23-12:21
 */
public class NumberToIP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            System.out.println(trans(s));
        }
    }

    public static String trans(String s) {
        // ip to number
        if (s.contains(".")) {
            String[] arr = s.split("\\.");
            long res = 0L;
            for (String num : arr) {
                res = res * 256 + Integer.valueOf(num);
            }
            return String.valueOf(res);
        } else {
            // number to ip
            long ip = Long.parseLong(s);
            String res = "";
            for (int i = 0; i < 4; i++) {
                res = ip % 256 + "." + res;
                ip /= 256;
            }
            return res.substring(0, res.length() - 1);
        }
    }
}
