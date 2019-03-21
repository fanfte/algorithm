package jzoffer;

import java.util.Stack;

/**
 * Created by tianen on 2019/3/20
 *
 * @author fanfte
 * @date 2019/3/20
 **/
public class Test05 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public void printListInverselyUsingIteration(ListNode node) {
        if (node == null) {
            return;
        }
        Stack<ListNode> s = new Stack<>();

        while (node != null) {
            s.add(node);
            node = node.next;
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop().val);
        }
    }

    public void printListInverselyUsingRecursion(ListNode node) {
        if (node != null) {
            printListInverselyUsingRecursion(node.next);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        new Test05().printListInverselyUsingIteration(node);
        new Test05().printListInverselyUsingRecursion(node);
    }
}
