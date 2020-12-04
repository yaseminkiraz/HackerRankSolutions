package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

public class SinglyLinkedList {
    Node head; // head of list

    public static class Node {

        int data;
        Node next;

        Node(int d, Node nextNode) {
            data = d;
            next = nextNode;
        }
    }

    public SinglyLinkedList addNode(SinglyLinkedList list, int data){
        Node newNode = new Node(data,null);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

        return list;
    }

    public static SinglyLinkedList getSimpleList(){
        SinglyLinkedList list = new SinglyLinkedList();

        list.addNode(list, 10);
        list.addNode(list, 22);
        list.addNode(list, 33);
        list.addNode(list, 44);
        list.addNode(list, 60);
        list.addNode(list, 60);

        return list;
    }
}
