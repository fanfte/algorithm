package leetcode.list;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/6/23
 * ReverseLinkedList
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
