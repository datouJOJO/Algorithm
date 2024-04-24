package org.example.niuke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: DiDi
 * @Description: 明明的随机数
 * @Data: 2024-04-23-11:00
 */
public class MingMingDeSuiJiShu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();
        // 快速排序
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
        int index = partition(arr, left, right);
        sort(arr, left, index - 1);
        sort(arr, index + 1, right);
    }
}
