package org.example.model.LinkedList;

/**
 * @Author: DiDi
 * @Description: 链表节点信息
 * @Data: 2024-03-20-18:20
 */

public class ListNode {

    /**
     * 节点值
     */
    private int val;

    public ListNode getNext() {
        return next;
    }

    /**
     * 下一个节点
     */
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
