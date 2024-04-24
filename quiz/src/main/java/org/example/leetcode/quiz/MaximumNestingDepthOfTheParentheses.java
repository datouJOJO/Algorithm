package org.example.leetcode.quiz;

import java.util.Stack;

/**
 * @Author: DiDi
 * @Description: 括号的最大嵌套深度
 * @Data: 2024-04-23-20:40
 */
public class MaximumNestingDepthOfTheParentheses {

    public static int maxDepth(String s) {
        char[] charArray = s.toCharArray();
        int maxDept = 0;
        int level = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ('(' == c) {
                level++;
                maxDept = Math.max(maxDept, level);
            } else if (')' == c) {
                level--;
            }
        }
        return maxDept;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
