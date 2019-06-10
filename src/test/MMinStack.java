package test;

import java.util.Stack;

/**
 * Created by tianen on 2019/6/3
 *
 * @author fanfte
 * @date 2019/6/3
 **/
public class MMinStack {

    static class MinStack {

        private Stack<Integer> s1 ;
        private Stack<Integer> s2 ;

        /** initialize your data structure here. */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            if (!s1.isEmpty()) {
                if (s2.peek() > x) {
                    s2.push(x);
                } else {
                    s2.push(s2.peek());
                }
            } else {
                s2.push(x);
            }
            s1.push(x);
        }

        public void pop() {
            if (s1.isEmpty()) {
                throw new IllegalArgumentException("s1 is empty");
            }
            s1.pop();
            s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
