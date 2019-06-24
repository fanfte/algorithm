package leetcode.stackandqueue;

import com.sun.javafx.image.IntPixelGetter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test225 {
    class MyStack {

        private Queue<Integer> q;

        /** Initialize your data structure here. */
        public MyStack() {
            q = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q.add(x);
            for (int i = 1; i < q.size(); i ++) {
                q.add(q.remove());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.remove();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
