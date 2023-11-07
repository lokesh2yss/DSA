package linkedlist;

public class SortList {
    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) {
            return A;
        }
        ListNode left = A;
        ListNode right = getMid(A);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    public ListNode merge(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode current1 = A;
        ListNode current2 = B;
        while(current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                dummy.next = current1;
                dummy = dummy.next;
                current1 = current1.next;
            }
            else {
                dummy.next = current2;
                dummy = dummy.next;
                current2 = current2.next;
            }
        }
        dummy.next = (current1==null)? current2:current1;
        return dummyHead.next;
    }
}
