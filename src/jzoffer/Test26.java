package jzoffer;

/**
 * Created by tianen on 2019/4/1
 *
 * @author fanfte
 * @date 2019/4/1
 **/
public class Test26 {

    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    public ComplexListNode clone(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        cloneNodes(head);
        connectSublings(head);
        return reconnectNodes(head);
    }

    private ComplexListNode reconnectNodes(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        ComplexListNode cloneNode = head.next;
        ComplexListNode node = cloneNode;
        head.next = cloneNode.next;
        head = head.next;

        while (head != null) {
            node.next = head.next;
            node = node.next;

            head.next = node.next;
            head = node.next;
        }
        return null;
    }

    private void connectSublings(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneNode = head.next;

        while(node != null) {
            if (node.sibling != null) {
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }
    }

    private void cloneNodes(ComplexListNode head) {
        while(head != null) {
            ComplexListNode cloneNode = new ComplexListNode();
            cloneNode.value = head.value;
            cloneNode.next = head.next;
            head.next = cloneNode;
            head = cloneNode.next;
        }
    }


}
