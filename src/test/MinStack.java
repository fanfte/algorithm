package test;

import java.util.Stack;

/**
 * Created by tianen on 2019/5/26
 *
 * @author fanfte
 * @date 2019/5/26
 **/
public class MinStack {

    private Stack<Integer> s1 = new Stack<>();

    private Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
        if (s2.isEmpty() || node < s2.peek()) {
            s2.push(node);
        } else {
            s2.push(s2.peek());
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
