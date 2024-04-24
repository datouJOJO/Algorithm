package org.example.niuke;

import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-22-16:10
 */
public class SheXingJuZhen {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int level = 0;
        int num = 1;
        while (level < n) {
            int timer = 0;
            int i = level, j = 0;
            while(timer <= level) {
                arr[i][j] = num;
                i--;
                j++;
                num++;
                timer++;
            }
            level++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
