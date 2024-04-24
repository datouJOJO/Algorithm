package org.example.sort;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 插入排序
 * @Data: 2024-04-02-16:48
 */
public class InsertSort {

    public static int[] sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int base = arr[i];
            int j = i - 1;
            // 大于基数向右移动
            while(j >= 0 && arr[j] > base) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = base;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
