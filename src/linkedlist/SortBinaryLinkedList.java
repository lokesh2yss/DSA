package linkedlist;

public class SortBinaryLinkedList {
    public ListNode sortBinaryList(ListNode A) {
        ListNode p1 = A;
        ListNode p2 = A;
        while(p1 !=null) {
            if(p1.val==0) {
                swap(p1,p2);
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return A;
    }
    public void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
