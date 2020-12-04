package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

/* Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 * Complexity: O(n)
*/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P02_KthToLast {
    private String kthToLast(SinglyLinkedList.Node head, int i) {
        StringBuilder listText = new StringBuilder();
        SinglyLinkedList.Node current = head;
        int index = 0;
        while (current != null)
        {
            index++;

            if(index>=i)
            {
                listText.append(current.data);
                listText.append(" ");
                System.out.println("index:" + index + " data:" + current.data);
            }

            current = current.next;
        }

        return listText.toString().trim();
    }

    private int printKToLast(SinglyLinkedList.Node head, int k) {
        if(head == null)
            return 0;

        int index = printKToLast(head.next,k) + 1;
        if(index == k)
            System.out.println("index:" + index + " data:" + head.data);
        return index;
    }

    @Test
    public void test() {
        SinglyLinkedList list = SinglyLinkedList.getSimpleList();
        assertEquals(kthToLast(list.head,3),"33 44 60 60");
    }
}
