package org.example.niuke;

import java.util.*;

/**
 * @Author: DiDi
 * @Description: 称砝码
 * @Data: 2024-04-23-22:05
 */
public class ChengFaMa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fama = new int[n];
        List<Integer> choice = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            fama[i] = weight;
        }
        for (int i = 0; i < n; i++) {
            int j = sc.nextInt();
            while(j-- > 0) {
                choice.add(fama[i]);
            }
        }
        Arrays.sort(choice.toArray());
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), choice, new boolean[choice.size()], res, 0);
        // 砝码和去重
        Set<Integer> set = new HashSet<>();
        for (List<Integer> re : res) {
            int count = 0;
            for (Integer num : re) {
                count += num;
            }
            set.add(count);
        }
        System.out.println(set.size());
    }

    public static void backtrack(List<Integer> state, List<Integer> choice, boolean[] selected, List<List<Integer>> res,
                                 int start) {
        if (start > choice.size()) {
            return;
        }
        res.add(new ArrayList<>(state));
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < choice.size(); i++) {
            if (!selected[i] && !set.contains(choice.get(i))) {
                selected[i] = true;
                state.add(choice.get(i));
                set.add(choice.get(i));
                backtrack(state, choice, selected, res, i + 1);
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }
}
