package linkedlist;

public class RemoveNthNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        //Bth node from the end is (N- b +1)th node from start
        ListNode current = A;
        int length = 0;
        while(current !=null) {
            length++;
            current = current.next;
        }
        if(B >=length) {
            return A.next;
        }
        current = A;
        ListNode prev = null;
        for(int i=0; i< length-B; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        return A;



    }
}
