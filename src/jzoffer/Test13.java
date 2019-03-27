package jzoffer;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test13 {

    public ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return null;
        }

        if (head == toBeDeleted) {
            return head.next;
        }

        if (toBeDeleted.next == null) {
            ListNode temp = head;
            while(temp.next != toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        } else {
            toBeDeleted.value = toBeDeleted.next.value;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        return head;
    }
}
