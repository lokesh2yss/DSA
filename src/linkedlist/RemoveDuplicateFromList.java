package linkedlist;

public class RemoveDuplicateFromList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            if (prev != null && current.val == prev.val) {
                //delete current node
                prev.next = current.next;
                current = current.next;
                continue;
            }
            prev = current;
            current = current.next;
        }

        return head;
    }
}
