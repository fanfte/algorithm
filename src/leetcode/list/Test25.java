package leetcode.list;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count ++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count -- > 0) {
                ListNode next = head.next;
                head.next = cur;
                cur = head;
                head = next;
            }
            head = cur;
        }
        return head;
    }

}
