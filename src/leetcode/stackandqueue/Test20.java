package leetcode.stackandqueue;

import java.util.Stack;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i ++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (isCompatible(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                        stack.push(s.charAt(i));
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isCompatible(Character stackTop, char c) {
        if (stackTop == '(' && c == ')') {
            return true;
        }
        if (stackTop == '[' && c == ']') {
            return true;
        }
        if (stackTop == '{' && c == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test20().isValid("()[]{}"));
    }


}
