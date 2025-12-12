package com.collections;

import java.util.Stack;

public class StackDemo {

    public void stackMethods() {
        //ADD
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushes: " + stack);

        //RETRIEVE
        int top = stack.peek();
        System.out.println("Top element: " + top);

        int indexFromTop = stack.search(30);
        System.out.println("Index of 30 from top: " + indexFromTop);

        //REMOVE
        int popped = stack.pop();
        System.out.println("Popped element: " + popped);
        System.out.println("Stack after pop: " + stack);

    }
}
