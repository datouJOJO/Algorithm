package org.example.niuke;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-22-16:55
 */
public class BIaoShiShuZi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                if (stack.isEmpty() || !Character.isDigit(stack.peek())) {
                    stack.add('*');
                }
                stack.add(c);
            } else {
                if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    stack.add('*');
                }
                stack.push(c);
            }
        }
        if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
            stack.add('*');
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }
}
