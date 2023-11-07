package linkedlist;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode A, int m, int n) {
        ListNode dummy = new ListNode(-1, A);
        ListNode prevLeft = dummy;
        ListNode current = A;
        ListNode prev = null;
        for(int i=0; i< m-1; i++) {
            prev = current;
            current = current.next;
        }
        prevLeft = prev;
        prev =  null;

        for(int i=0;i<n-m+1; i++) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        if(prevLeft == null) {
            prevLeft = dummy;
        }
        if(prevLeft != null && prevLeft.next != null) {
            prevLeft.next.next = current;
            prevLeft.next = prev;
        }
        else {
            dummy.next = prev;
        }
        return dummy.next;
    }
}
