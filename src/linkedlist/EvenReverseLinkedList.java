package linkedlist;

public class EvenReverseLinkedList {
    public ListNode evenReverse(ListNode A) {
        ListNode odd = A;
        ListNode even = null;
        ListNode oddHead = A;
        while(odd != null && odd.next != null) {
            ListNode temp = odd.next;
            odd.next = odd.next.next;
            temp.next = even;
            even = temp;
            //System.out.println(temp.val);
            odd = odd.next;

        }
        return merge(oddHead, even);
    }
    public ListNode merge(ListNode first, ListNode second) {
        ListNode current1 = first;
        ListNode current2 = second;
        ListNode dummy = new ListNode(-1);
        ListNode merged = dummy;
        int count = 1;
        while(current1 != null && current2 != null) {
            if(count%2 ==1) {
                dummy.next = current1;
                dummy = dummy.next;
                current1 = current1.next;
            }
            else {
                dummy.next = current2;
                dummy = dummy.next;
                current2 = current2.next;
            }
            count++;
        }
        dummy.next = (current1==null)? current2:current1;
        return merged.next;
    }
}
