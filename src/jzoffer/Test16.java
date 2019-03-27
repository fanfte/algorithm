package jzoffer;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test16 {

    public ListNode reverseList(ListNode node) {

        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
