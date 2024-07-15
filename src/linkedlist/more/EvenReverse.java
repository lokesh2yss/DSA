package linkedlist.more;
class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
}
public class EvenReverse {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        printList(n1);
        ListNode a = solve(n1);
        printList(a);
    }
    static public ListNode solve(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode oddListHead = head, oddList = head;
        ListNode evenListHead = head.next, evenList = head.next;
        ListNode current = evenList.next;
        int count = 0;
        while(current != null) {
            if(count%2 == 0) {
                oddList.next = current;
                oddList = oddList.next;
            }
            else {
                evenList.next = current;
                evenList = evenList.next;
            }
            current = current.next;
            count++;
        }
        oddList.next = null;
        evenList.next = null;
        printList(oddListHead);
        printList(evenListHead);
        //reverse even list
        current = evenListHead;
        ListNode prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        evenListHead = prev;

        //merge back the two lists
        count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode mergedList = dummy;
        while(oddListHead != null && evenListHead != null) {
            if(count%2 == 0) {
                mergedList.next = oddListHead;
                oddListHead = oddListHead.next;
            }
            else {
                mergedList.next = evenListHead;
                evenListHead = evenListHead.next;
            }
            mergedList = mergedList.next;
            count++;
        }
        if(oddListHead == null) {
            mergedList.next = evenListHead;
        }
        if(evenListHead == null) {
            mergedList.next = oddListHead;
        }
        return dummy.next;

    }
    public static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}
