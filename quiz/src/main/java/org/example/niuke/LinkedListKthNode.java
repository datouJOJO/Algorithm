package org.example.niuke;

import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-22-17:29
 */
public class LinkedListKthNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            ListNode root = new ListNode(-1);
            ListNode cur = root;
            while (n-- > 0) {
                int k = sc.nextInt();
                ListNode newNode = new ListNode(k);
                cur.next = newNode;
                cur = newNode;
            }
            int k = sc.nextInt();
            ListNode fast = root;
            ListNode slow = root;
            while (k-- > 0) {
                if (fast == null) {
                    throw new NullPointerException();
                }
                fast = fast.next;
            }
            while(fast!= null) {
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(slow.val);
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        this.val = x;
    }
};

