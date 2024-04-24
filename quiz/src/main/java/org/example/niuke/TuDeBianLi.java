package org.example.niuke;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: DiDi
 * @Description: 图的遍历
 * @Data: 2024-04-22-23:50
 */
public class TuDeBianLi {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList[] arr = new ArrayList[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        int[] visited = new int[n + 1];
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        visited[1] = 1;
        while(!stack.isEmpty()) {
            len++;
            Stack<Integer> tmpStack = new Stack<>();
            while(!stack.isEmpty()) {
                Integer node = stack.pop();
                ArrayList<Integer> nearNodes = arr[node];
                for (Integer t : nearNodes) {
                    if (visited[t] == 0) {
                        visited[t] = 1;
                        tmpStack.add(t);
                    }
                }
            }
            stack = tmpStack;
        }
        System.out.println(2 * (n - 1) - len + 1);
    }
}
