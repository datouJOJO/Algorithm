package org.example.sort;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 选择排序
 * @Data: 2024-04-02-16:59
 */
public class SelectSort {

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2, 4, 1, 3})));
    }
}
