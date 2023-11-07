package linkedlist;

public class KthNodeFromMiddle {
    public int kthNode(ListNode head, int B) {
        //find the middle element and index
        ListNode slow = head;
        ListNode fast = head;
        int middle = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            middle++;

        }
        //now we have middle element
        //Bth index from middle is
        //(middle - B)th element from the beginning
        slow = head;
        int count = 1;
        while (slow != null) {
            if (count == middle - B) {
                return slow.val;
            }
            slow = slow.next;
            count++;
        }
        return -1;

    }
}
