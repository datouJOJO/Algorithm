package org.example.model.queue;

import org.example.model.LinkedList.ListNode;

import java.util.Objects;

/**
 * @Author: DiDi
 * @Description: 链表实现队列
 * @Data: 2024-03-21-18:08
 */
public class LinkedListQueue {

    private ListNode head, tail;

    private Integer size;

    public LinkedListQueue() {
        this.size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(Integer val) {
        ListNode newNode = new ListNode(val);
        if (Objects.isNull(this.head)) {
            this.head = this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.head.getVal();
    }

    public Integer remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Integer peekVal = this.head.getVal();
        this.head = this.head.getNext();
        this.size--;
        return peekVal;
    }

    public static void main(String[] args) {
        LinkedListQueue arrayListQueue = new LinkedListQueue();
        System.out.println(arrayListQueue.getSize());
        arrayListQueue.push(2);
        System.out.println(arrayListQueue.getSize());
        System.out.println(arrayListQueue.peek());
        System.out.println(arrayListQueue.remove());
        System.out.println(arrayListQueue.getSize());
        arrayListQueue.push(1);
        System.out.println(arrayListQueue.peek());
        arrayListQueue.push(2);
        System.out.println(arrayListQueue.getSize());
        System.out.println(arrayListQueue.peek());
    }
}
