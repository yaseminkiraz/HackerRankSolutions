package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

import org.junit.jupiter.api.Test;
import yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists.SinglyLinkedList.Node;

import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * HINTS:
 * Have you tried a hash table? You should be able to do this in a single pass of the linked
 * list.
 * Without extra space, you'll need time.
 * Try using two pointers, where the second one searches ahead of the first one.
 * */

public class P01_RemoveDups {

    private String removeDuplicate(Node head) {
        if(head == null)
            return null;

        HashSet<Integer> hs = new HashSet<>();

        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.data;

            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

        return printList(head);
    }

    private String printList(Node head) {
        Node curr = head;
        StringBuilder listText = new StringBuilder();

        while(curr != null)
        {
            listText.append(curr.data);
            listText.append(" ");
            curr = curr.next;
        }

        return listText.toString().trim();
    }

    @Test
    public void test() {
        SinglyLinkedList list = SinglyLinkedList.getSimpleList();
        assertEquals(removeDuplicate(list.head),"10 22 33 44 60");
    }

}

