package org.example.model.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DiDi
 * @Description: 列表实现队列
 * @Data: 2024-03-21-18:35
 */
public class ArrayListQueue {

    private List<Integer> queue;

    private Integer size;

    public ArrayListQueue() {
        this.queue = new ArrayList<>();
        this.size = 0;
    }

    public Integer getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(Integer val) {
        queue.add(val);
        this.size++;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.queue.get(0);
    }

    public Integer remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Integer peekVal = this.queue.get(0);
        for(int i = 1; i < size; i++) {
            // 所有元素向前移动1位
            this.queue.set(i - 1, this.queue.get(i));
        }
        this.size--;
        return peekVal;
    }

    public static void main(String[] args) {
        ArrayListQueue arrayListQueue = new ArrayListQueue();
        arrayListQueue.push(1);
        arrayListQueue.push(2);
        arrayListQueue.push(3);
        arrayListQueue.push(4);
        System.out.println(arrayListQueue.getSize());
        System.out.println(arrayListQueue.peek());
        System.out.println(arrayListQueue.remove());
        System.out.println(arrayListQueue.getSize());
        System.out.println(arrayListQueue.peek());
        System.out.println(arrayListQueue.remove());
        System.out.println(arrayListQueue.remove());
        System.out.println(arrayListQueue.remove());
        System.out.println(arrayListQueue.getSize());
    }
}
