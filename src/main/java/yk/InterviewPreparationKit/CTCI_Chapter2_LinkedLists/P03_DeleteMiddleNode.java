package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

/*
* Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
* EXAMPLE
    Input: the node c from the linked list a - >b- >c - >d - >e- >f
    Result: nothing is returned, but the new linked list looks like a->b->d->e-> f
* */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P03_DeleteMiddleNode {
    private String deleteMiddleNode(ListNode middle, ListNode list) {
        if(middle == null || middle.next == null)
            return null;

        ListNode deleted = middle.next;
        middle.next = deleted.next;
        middle.val = deleted.val;

        StringBuilder listText = new StringBuilder();

        ListNode current = list;
        while (current != null)
        {
            listText.append(current.val);
            listText.append(" ");
            System.out.println(current.val);
            current = current.next;
        }

        return listText.toString().trim();
    }

    @Test
    public void test() {
        ListNode list = new ListNode(3);
        list.next = new ListNode(5);
        list.next.next = new ListNode(7);
        list.next.next.next = new ListNode(9);
        list.next.next.next.next = new ListNode(10);
        assertEquals(deleteMiddleNode(list.next.next, list),"3 5 9 10");
    }

}
