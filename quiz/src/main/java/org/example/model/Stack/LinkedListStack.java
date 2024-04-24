package org.example.model.Stack;

import org.example.model.LinkedList.ListNode;

/**
 * @Author: DiDi
 * @Description: 链表生成栈
 * @Data: 2024-03-21-16:42
 */
public class LinkedListStack {

    private ListNode top;

    private Integer size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public Integer getSize() {
        return this.size;
    }

    /**
     * 入栈
     *
     * @param val   入栈元素
     */
    public void push(Integer val) {
        ListNode node = new ListNode(val);
        node.setNext(this.top);
        this.top = node;
        this.size++;
    }

    /**
     * 出栈
     * 顶上元素出栈
     */
    public Integer remove() {
        if (isEmpty()) {
            // 如果链表为空直接抛出异常
            throw new IndexOutOfBoundsException();
        }
        Integer peek = this.top.getVal();
        this.top = this.top.getNext();
        this.size--;
        return peek;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.top.getVal();
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        System.out.println(linkedListStack.getSize());
        // linkedListStack.remove();
        linkedListStack.push(2);
        System.out.println(linkedListStack.getSize());
        System.out.println(linkedListStack.peek());
        linkedListStack.push(3);
        System.out.println(linkedListStack.getSize());
        System.out.println(linkedListStack.peek());
        System.out.println(linkedListStack.remove());
        System.out.println(linkedListStack.getSize());
        System.out.println(linkedListStack.peek());
        System.out.println(linkedListStack.remove());
        System.out.println(linkedListStack.remove());
    }
}
