package org.example.leetcode.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DiDi
 * @Description: LCR 079. 子集
 * @Data: 2024-04-09-16:57
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0, res);
        return res;
    }

    public static void backtrack(List<Integer> state, int[] choices, int start, List<List<Integer>> res) {
        if (start > choices.length) {
            return;
        }
        res.add(new ArrayList<>(state));
        for (int i = start; i < choices.length; i++) {
            Integer choice = choices[i];
            state.add(choice);
            backtrack(state, choices, i + 1, res);
            state.remove(state.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
