package linkedlist;

public class IntersectionOfLinkedLists {
    public static int findIntersection(ListNode firstHead, ListNode secondHead) {
        ListNode a = firstHead;
        ListNode b = secondHead;

        while(a != b) {
            a = a == null? secondHead: a.next;
            b = b == null? firstHead: b.next;
        }
        if(a==null) {
            return -1;
        }
        return a.val;
    }
}
