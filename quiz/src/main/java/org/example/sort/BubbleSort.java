package org.example.sort;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 冒泡排序
 * @Data: 2024-04-02-16:57
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {
        boolean swap = false;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2, 4, 1, 3})));
    }
}
