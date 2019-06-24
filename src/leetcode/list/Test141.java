package leetcode.list;

import jzoffer.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tianen on 2019/6/23
 * LinkedListCycle
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test141 {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
