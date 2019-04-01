package jzoffer;

import java.util.Stack;

/**
 * Created by tianen on 2019/3/27
 *
 * @author fanfte
 * @date 2019/3/27
 **/
public class Test22 {

    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || push.length == 0 || pop == null || pop.length == 0) {
            return false;
        }
        int length = push.length;

        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> pushStack = new Stack<>();

        while (popIndex < length) {
            while(pushStack.isEmpty() || (pushIndex < length && pushStack.peek() != pop[popIndex])) {
                pushStack.push(push[pushIndex]);
                pushIndex ++;
            }
            if (pushStack.peek() == pop[popIndex]) {
                pushStack.pop();
                popIndex ++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};
        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));
        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));
        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));
        System.out.println("false: " + isPopOrder(null, null));
    }
}
