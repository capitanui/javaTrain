package com.icapitanu.array;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

/*
* @author ionutcapitanu on 2020-06-22 
*/
public class MyQueue <T> {

        private Stack<T> stackQueue;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackQueue = new Stack<>();
         }

        /** Push element x to the back of queue. */
        public void push(T t) {
            stackQueue.push(t);
        }

        /** Removes the element from in front of queue and returns that element. */
        public T pop() {
            stackQueue = reverseStack(stackQueue);
            T t = stackQueue.pop();
            stackQueue = reverseStack(stackQueue);
            return t;
        }

    /** Get the front element. */
        public T peek() {
            stackQueue = reverseStack(stackQueue);
            T t = stackQueue.peek();
            stackQueue = reverseStack(stackQueue);
            return t;
         }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackQueue.empty();
        }

        public Stack<T> reverseStack(Stack<T> stack){
            Stack<T> newStack = new Stack<>();
            Integer size = stack.size();


            for (int i = 0; i < size; i++){
                newStack.push(stack.pop());
            }
            return newStack;
        }

}
