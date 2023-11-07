package linkedlist;

public class EvenReverse {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        printList(n1);
        ListNode eReverse = evenReverse(n1);
        printList(eReverse);
        //printList(eReverse[1]);
    }
    public static ListNode evenReverse(ListNode head) {
        ListNode odd = head;
        ListNode even = null;
        ListNode oddHead = head;
        while(odd != null) {
            ListNode temp = odd.next;
            odd.next = odd.next.next;
            temp.next = even;
            even = temp;
            //System.out.println(temp.val);
            odd = odd.next;

        }
        return merge(oddHead, even);
    }
    public static ListNode merge(ListNode first, ListNode second) {
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
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "-> ");
            current = current.next;
        }
        System.out.println();
    }
}
