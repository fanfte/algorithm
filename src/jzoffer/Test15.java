package jzoffer;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test15 {

    public ListNode findKthFromTail(ListNode node, int k) {
        if (node == null || k < 1) {
            return null;
        }
        ListNode fastNode = node;
        int step = 1;
        while (step < k ) {
            if (fastNode.next != null) {
                fastNode = fastNode.next;
            } else {
                return null;
            }
            step ++;
        }
        ListNode slowNode = node;

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.value = 1;
        head.next = new ListNode();
        head.next.value = 2;
        head.next.next = new ListNode();
        head.next.next.value = 3;
        head.next.next.next = new ListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ListNode();
        head.next.next.next.next.value = 5;
        head.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.value = 6;
        head.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.value = 7;
        head.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.value = 8;
        head.next.next.next.next.next.next.next.next = new ListNode();
        head.next.next.next.next.next.next.next.next.value = 9;
        Test15 t = new Test15();
        System.out.println(t.findKthFromTail(head, 1).value); // 倒数第一个
        System.out.println(t.findKthFromTail(head, 5).value); // 中间的一个
        System.out.println(t.findKthFromTail(head, 9).value); // 倒数最后一个就是顺数第一个
        System.out.println(t.findKthFromTail(head, 10));
    }
}
