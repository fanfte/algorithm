package jzoffer;

import java.util.Stack;

/**
 * Created by tianen on 2019/3/21
 *
 * @author fanfte
 * @date 2019/3/21
 **/
public class MQueue<T> {

    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public void push(T t) {
        s1.add(t);
    }

    public T deleteHead() throws Exception {
        while(!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        if (s2.isEmpty()) {
            throw new Exception("no more elements.");
        }
        return s2.pop();
    }
}
