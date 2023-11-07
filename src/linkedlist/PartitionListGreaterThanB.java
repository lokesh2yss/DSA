package linkedlist;

public class PartitionListGreaterThanB {
    public ListNode partition(ListNode A, int B) {
        ListNode dummy1 = new ListNode(-1);
        ListNode newHead = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy2Head = dummy2;
        ListNode current = A;
        while(current != null) {
            if(current.val < B) {
                dummy1.next = current;
                current = current.next;
                dummy1 = dummy1.next;
            }
            else {
                dummy2.next = current;
                current = current.next;
                dummy2 = dummy2.next;
                dummy2.next = null;
            }
        }
        dummy1.next = dummy2Head.next;
        return newHead.next;
    }

}
