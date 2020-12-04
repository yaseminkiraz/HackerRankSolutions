package yk.InterviewPreparationKit.CTCI_Chapter2_LinkedLists;

public class RunnerTechnique {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(3);
        list.next = new ListNode(5);
        list.next.next = new ListNode(7);
        list.next.next.next = new ListNode(9);
        list.next.next.next.next = new ListNode(10);
        list.next.next.next.next.next = list.next.next;

        ListNode result = detectCycle(list);
        System.out.println(result == null ? "no cycle" : result.val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (slow != null && fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }


        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }


        return slow;
    }

}
