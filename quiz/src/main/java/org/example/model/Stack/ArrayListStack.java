package org.example.model.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DiDi
 * @Description: 列表栈
 * @Data: 2024-03-21-17:24
 */
public class ArrayListStack {

    private List<Integer> stack;

    private Integer size;

    public ArrayListStack() {
        this.stack = new ArrayList<>();
        this.size = 0;
    }

    public Integer getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(Integer val) {
        stack.add(val);
        this.size++;
    }

    public Integer remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Integer val = this.stack.get(getSize() - 1);
        this.size--;
        return val;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.stack.get(getSize() - 1);
    }

    public static void main(String[] args) {
        ArrayListStack arrayListStack = new ArrayListStack();
        // arrayListStack.remove();
        arrayListStack.push(1);
        System.out.println(arrayListStack.getSize());
        System.out.println(arrayListStack.peek());
        System.out.println(arrayListStack.remove());
        System.out.println(arrayListStack.getSize());
        // System.out.println(arrayListStack.peek());
    }
}
