package org.example.work.huaweiod;

import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-26-14:05
 */
public class Quiz3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 宽
        int w = in.nextInt(), h = in.nextInt();
        // 初始坐标
        int x = in.nextInt(), y = in.nextInt();
        // 初始速度
        int sx = in.nextInt(), sy = in.nextInt();
        // 经过时间 （迭代次数）
        int t = in.nextInt();

        int[][] arr = new int[h][w];
        // 读取矩阵
        in.nextLine();
        for (int i = 0; i < h; i++) {
            String s = in.nextLine();
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        // 计数
        int count = 0;
        for (int i = 0; i <= t; i++) {
            if (arr[y][x] == 1) {
                count++;
            }
            if (x == 0 && y == 0) {
                // x增加 y增加
                sx = Math.abs(sx);
                sy = Math.abs(sy);
            } else if (x == 0 && y == h - 1){
                // x增加 y减少
                sx = Math.abs(sx);
                sy = -Math.abs(sy);
            } else if (x == w - 1 && y == 0) {
                // x减少 y增加
                sx = -Math.abs(sx);
                sy = Math.abs(sy);
            } else if (x == w - 1 && y == h - 1) {
                // x减少 y减少
                sx = -Math.abs(sx);
                sy = -Math.abs(sy);
            } else {
                // 碰到上边界/下边界
                if (y == 0 || y == h - 1) {
                    sy = -sy;
                }
                if (x == 0 || x == w - 1) {
                    // 碰到左边界
                    sx = -sx;
                }
            }
            x += sx;
            y += sy;
        }
        System.out.println(count);
    }
}
