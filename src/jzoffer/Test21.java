package jzoffer;

import java.util.Stack;

/**
 * Created by tianen on 2019/3/27
 *
 * @author fanfte
 * @date 2019/3/27
 **/
public class Test21 {

    public static class StafkWithMin<T extends Comparable<T>> {
        private Stack<T> dataStack;

        private Stack<T> minStack;

        public StafkWithMin() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(T data) throws Exception {
            if (data == null) {
                throw new Exception("Data must not be empth.");
            }
            dataStack.push(data);
            if (minStack.isEmpty()) {
                minStack.push(data);
            }
            if (minStack.peek().compareTo(data) > 0) {
                minStack.push(data);
            }
        }

        public T pop() throws Exception {
            if (dataStack.isEmpty()) {
                throw new Exception("No more elements.");
            }
            T result = null;
            if (dataStack.peek() == minStack.peek()) {
                minStack.pop();
            }
            result = dataStack.pop();
            return result;
        }

    }
}
