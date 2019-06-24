package leetcode.stackandqueue;

import java.util.Stack;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test232 {
    static class MyQueue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
    }
}
