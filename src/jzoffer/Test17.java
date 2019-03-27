package jzoffer;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test17 {

    public ListNode mergeTwoListNodes(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode mergedHead = null;
        if (node1.value < node2.value) {
            mergedHead = node1;
            mergedHead.next = mergeTwoListNodes(node1.next, node2);
        } else {
            mergedHead = node2;
            mergedHead.next = mergeTwoListNodes(node1, node2.next);
        }
        return mergedHead;
    }
}
