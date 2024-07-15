package designgurus;
class ListNode {
    int val = 0;
    ListNode next;

    ListNode(int value) {
        this.val = value;
    }
}
public class LengthOfLinkedListCycle {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        /*ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);*/
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        /*n7.next = n8;
        n8.next = n9;
        n9.next = n10;*/
        System.out.println(cycleLength(n1));
    }
    public static int cycleLength(ListNode head) {
        if(head==null) return 0;
        ListNode slow = head;
        ListNode fast = head;
        boolean cyclePresent = false;
        int meetingDistance = 0;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            meetingDistance +=2;
            if(slow == fast) {
                cyclePresent = true;
                break;
            }
        }
        if(!cyclePresent) return 0;
        ListNode current = slow;
        int length = 0;
        do {
           current = current.next;
           length++;
        } while(current != slow);
        return length;
    }
}
