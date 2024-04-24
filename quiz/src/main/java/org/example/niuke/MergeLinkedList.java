package org.example.niuke;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: DiDi
 * @Description: 合并两个链表
 * @Data: 2024-04-22-21:46
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split(" ");
        ListNode root1 = buildLinkedList(arr1);
        String[] arr2 = sc.nextLine().split(" ");
        ListNode root2 = buildLinkedList(arr2);
        ListNode res = new ListNode(-1);
        mergeLinkedList(root1, root2, res);
        res = res.next;
        while(res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode buildLinkedList(String[] arr) {
        ListNode root = new ListNode(-1);
        ListNode cur = root;
        for (String s : arr) {
            ListNode tmp = new ListNode(Integer.parseInt(s));
            cur.next = tmp;
            cur = tmp;
        }
        return root.next;
    }

    public static void mergeLinkedList(ListNode root1, ListNode root2, ListNode res) {
        ListNode cur = res;
        while(root1 != null && root2 != null) {
            if (root1.val <= root2.val) {
                cur.next = root1;
                root1 = root1.next;
            } else {
                cur.next = root2;
                root2 = root2.next;
            }
            cur = cur.next;
        }
        if (root1 != null) {
            cur.next = root1;
        }
        if (root2 != null) {
            cur.next = root2;
        }
    }

}

class MyListNode {
    public int val;
    public ListNode next;
    public MyListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
