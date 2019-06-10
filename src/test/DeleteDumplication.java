package test;

import jzoffer.datastruct.ListNode;

/**
 * Created by tianen on 2019/6/1
 *
 * @author fanfte
 * @date 2019/6/1
 **/
public class DeleteDumplication {

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) {
            return pHead;
        }
        if (pHead.next == null) {
            return pHead;
        }

        ListNode current;
        if (pHead.next.value == pHead.value) {
            current = pHead.next.next;
            while (current!= null && current.value == pHead.value) {
                current = current.next;
            }
            return deleteDuplication(current);
        } else {
            current = pHead.next;
            pHead.next = deleteDuplication(current);
            return pHead;
        }
    }
}
