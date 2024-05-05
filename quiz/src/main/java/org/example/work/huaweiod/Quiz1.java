package org.example.work.huaweiod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-26-14:05
 */
public class Quiz1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 总人数
        int numOfPeople = in.nextInt();
        // 每个人的能力值
        int[] peopleArr = new int[numOfPeople];
        for (int i = 0; i < numOfPeople; i++) {
            peopleArr[i] = in.nextInt();
        }
        // 需要的最少能量
        int energy = in.nextInt();
        Arrays.sort(peopleArr);
        int res = 0;
        int i = 0, j = peopleArr.length - 1;
        while(i <= j) {
            if (peopleArr[j] >= energy) {
                j--;
                res++;
            } else if (peopleArr[j] + peopleArr[i] >= energy) {
                j--;
                i++;
                res++;
            } else {
                i++;
            }
        }
        System.out.println(res);
    }
}
