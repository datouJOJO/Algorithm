package org.example.niuke;

import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-22-15:40
 */
public class JinZhiZhuanHuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(Integer.parseInt(str.substring(2), 16));
        }
    }
}
