package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

/*
Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
to be after the elements less than x (see below). The partition element x can appear anywhere in the
"right partition"; it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
*/

public class P04_Partition {
    static class Node {
        int data;
        Node next;
    }

    static Node newNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = null;
        return new_node;
    }

    static Node partition(Node head, int x) {
        Node smallerHead = null, smallerLast = null;
        Node greaterLast = null, greaterHead = null;
        Node equalHead = null, equalLast = null;

        while (head != null) {
            if (head.data == x) {
                if (equalHead == null)
                    equalHead = equalLast = head;
                else {
                    equalLast.next = head;
                    equalLast = equalLast.next;
                }
            }
            else if (head.data < x) {
                if (smallerHead == null)
                    smallerLast = smallerHead = head;
                else {
                    smallerLast.next = head;
                    smallerLast = head;
                }
            } else
            {
                if (greaterHead == null)
                    greaterLast = greaterHead = head;
                else {
                    greaterLast.next = head;
                    greaterLast = head;
                }
            }
            head = head.next;
        }

        if (greaterLast != null)
            greaterLast.next = null;

        if (smallerHead == null) {
            if (equalHead == null)
                return greaterHead;
            equalLast.next = greaterHead;
            return equalHead;
        }

        if (equalHead == null) {
            smallerLast.next = greaterHead;
            return smallerHead;
        }

        smallerLast.next = equalHead;
        equalLast.next = greaterHead;
        return smallerHead;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = newNode(10);
        head.next = newNode(4);
        head.next.next = newNode(5);
        head.next.next.next = newNode(30);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(50);

        int x = 3;
        head = partition(head, x);
        printList(head);
    }
}
