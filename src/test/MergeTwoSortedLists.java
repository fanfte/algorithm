package test;

import jzoffer.datastruct.ListNode;

import java.util.List;

/**
 * Created by tianen on 2019/6/3
 *
 * @author fanfte
 * @date 2019/6/3
 **/
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = (l1.value < l2.value) ? l1 : l2;

        ListNode index1 = head == l1 ? l1 : l2;
        ListNode index2 = head == l1 ? l2 : l1;
        ListNode pre = null;
        ListNode next = null;
        while (index1 != null && index2 != null) {
            if (index1.value <= index2.value) {
                pre = index1;
                index1 = index1.next;
            } else {
                next = index2.next;
                pre.next = index2;
                index2.next = index1;
                pre = index2;
                index2 = next;
            }
        }
        pre.next = index1 == null ? index2 : index1;
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return res.next;
    }
}
