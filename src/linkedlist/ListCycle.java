package linkedlist;

public class ListCycle {
    public ListNode detectCycle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        boolean isCyclePresent = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) {
                isCyclePresent = true;
                break;
            }
        }
        if(!isCyclePresent) {
            return null;
        }
        slow = A;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
