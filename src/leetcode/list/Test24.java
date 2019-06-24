package leetcode.list;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test24 {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        pre.next = head;
        ListNode a = null;
        ListNode b = null;
        while (pre.next != null && pre.next.next != null) {
            a = pre.next;
            b = a.next;
            ListNode next = b.next;
            pre.next = b;
            b.next = a;
            a.next = next;
            pre = a;
        }
        return res.next;
    }
}
