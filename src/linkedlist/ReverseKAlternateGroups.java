package linkedlist;

public class ReverseKAlternateGroups {
    public ListNode solve(ListNode A, int B) {
        ListNode current = A;
        ListNode next=null, prev=null;
        int count = 0;
        //reverse first B elements
        while(current != null && count < B) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(A != null) {
            A.next = current;
        }
        //skip next k nodes
        count = 0;
        while(current!= null && count< B-1) {
            current = current.next;
            count++;
        }
        //recursively call solve function on current.next node
        if(current != null) {
            current.next = solve(current.next,B);
        }
        return prev;
    }
}
