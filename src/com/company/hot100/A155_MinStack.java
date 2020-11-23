package com.company.hot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Classname 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *

 * @Date 2020/11/19 21:56
 * @Created by Mask
 */
public class A155_MinStack {
    Deque<Integer> stack ;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public A155_MinStack() {
        stack = new ArrayDeque<>();
        minStack =new ArrayDeque<>();
        minStack.addLast(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.addLast(x);
        minStack.addLast(Math.min(x,minStack.peekLast()));
    }

    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }
}
