package linkedlist;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode dummyNode = new ListNode();
        ListNode head = dummyNode;
        while(l1 != null && l2 !=null) {
            if(l1.val < l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
                dummyNode = dummyNode.next;
            }
            else {
                dummyNode.next = l2;
                l2 = l2.next;
                dummyNode = dummyNode.next;
            }
        }
        dummyNode.next = l1==null?l2:l1;
        return head.next;
    }
}
