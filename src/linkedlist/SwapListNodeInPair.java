package linkedlist;

public class SwapListNodeInPair {
    public ListNode swapPairs(ListNode A) {
        ListNode dummyNode  = new ListNode(-1);
        ListNode prev = dummyNode;
        ListNode current = A;
        dummyNode.next = A;
        while(current != null && current.next != null) {
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;
            current = current.next;
            prev = prev.next.next;
        }
        return dummyNode.next;
    }
}
