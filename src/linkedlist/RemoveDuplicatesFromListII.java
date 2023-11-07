package linkedlist;

public class RemoveDuplicatesFromListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode current = head;
        while(current != null ) {
            if(current.next !=null && current.val == current.next.val) {
                while(current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next;
            }
            else {
                prev = prev.next;

            }
            current = current.next;
        }

        return dummy.next;
    }
}
