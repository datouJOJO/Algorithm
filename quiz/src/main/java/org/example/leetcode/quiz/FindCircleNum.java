package org.example.leetcode.quiz;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-01-18:53
 */
public class FindCircleNum {

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0) return 0;
        int length = isConnected.length;
        int[][] visited = new int[length][length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && visited[i][j] == 0) {
                    dfs(visited, isConnected, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] visited, int[][]isConnected, int i, int j) {
        if (i < 0 || j < 0 || i > isConnected.length - 1 || j > isConnected.length - 1 || isConnected[i][j] == 0
                || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        for (int index = 0; index < isConnected.length; index++) {
            if (isConnected[j][index] == 1) {
                dfs(visited, isConnected, j, index);
            }
            visited[j][index] = 1;
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = new int[3][3];
        isConnected[0] = new int[]{1,1,0};
        isConnected[1] = new int[]{1,1,0};
        isConnected[2] = new int[]{0,0,1};
//        int[][] isConnected = new int[4][4];
//        isConnected[0] = new int[]{1,0,0,1};
//        isConnected[1] = new int[]{0,1,1,0};
//        isConnected[2] = new int[]{0,1,1,1};
//        isConnected[3] = new int[]{1,0,1,1};
        System.out.println(findCircleNum(isConnected));
    }
}
