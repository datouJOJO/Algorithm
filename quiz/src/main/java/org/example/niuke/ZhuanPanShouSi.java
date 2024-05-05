package org.example.niuke;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-26-12:28
 */
public class ZhuanPanShouSi {

    public static void main(String[] args) {
        int[] arr = {3, 15, 6, 14};
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int[] res = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            // 默认啥也不送
            res[j] = arr[j];
        }
        while(i < 2 * arr.length) {
            int index = i % arr.length;
            if (!stack.isEmpty() && arr[stack.peek()] > arr[index]) {
                res[stack.peek()] = arr[index] + arr[stack.pop()];
            }
            stack.push(index);
            i++;
        }
        System.out.println(Arrays.toString(res));
    }
}
