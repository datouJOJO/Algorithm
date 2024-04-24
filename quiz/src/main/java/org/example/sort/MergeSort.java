package org.example.sort;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 归并排序
 * @Data: 2024-04-08-17:10
 */
public class MergeSort {

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            tmp[k++] = arr[i++];
        }
        while(j <= right) {
            tmp[k++] = arr[j++];
        }
        for (k = 0; k < tmp.length; k++) {
            arr[left + k] = tmp[k];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
