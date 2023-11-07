package linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev= null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
