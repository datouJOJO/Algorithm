package org.example.sort;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 快速排序
 * @Data: 2024-04-02-17:11
 */
public class QuickSort {

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while(i < j && arr[j] >= arr[left]) j--;
            while(i < j && arr[i] <= arr[left]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, left);
        return i;
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) return;
        int partition = partition(arr, left, right);
        sort(arr, left, partition - 1);
        sort(arr, partition + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 3};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
