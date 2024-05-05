package org.example.leetcode.quiz;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 被围绕的区域
 * @Data: 2024-04-24-14:52
 */
public class SurroundedRegions {

    public static void solve(char[][] board) {
        int n = board.length; int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                backtrack(board, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                backtrack(board, i, m - 1);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                backtrack(board, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                backtrack(board, n - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void backtrack(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] == 'X'
                || board[x][y] == '-') {
            return;
        }
        board[x][y] = '-';
        backtrack(board, x - 1, y);
        backtrack(board, x + 1, y);
        backtrack(board, x, y - 1);
        backtrack(board, x, y + 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        board[0] = new char[]{'X', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X'};
        board[2] = new char[]{'X', 'X', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};
        solve(board);
        System.out.println(Arrays.toString(board));
    }
}
