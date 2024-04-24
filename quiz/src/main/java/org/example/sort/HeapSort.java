package org.example.sort;

import java.util.Arrays;

/**
 * @Author: DiDi
 * @Description: 堆排序
 * @Data: 2024-04-08-17:50
 */
public class HeapSort {

    public static void siftDown(int[] arr, int n, int i) {
        while(true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int idx = i;
            if (l < n && arr[i] < arr[l]) {
                i = l;
            }
            if (r < n && arr[i] < arr[r]) {
                i = r;
            }
            if (i == idx) break;
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
            i = idx;
        }
    }

    public static void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            siftDown(nums, i, 0);

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 3};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
