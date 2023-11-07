package linkedlist;

public class ReverseKGroups {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
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
        ListNode a = reverseKGroups(n1, 3);
        printList(a);
    }
    public static ListNode reverseKGroups(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevTail = dummy;
        ListNode curHead = head;
        while(curHead !=null) {
            ListNode curTail = findTailAfterK(curHead,k);
            if(curTail == null) break;
            ListNode nextHead = curTail.next;
            reverseKTimes(curHead,k);
            prevTail.next = curTail;
            prevTail = curHead;
            curHead = nextHead;
        }
        prevTail.next = curHead;
        return dummy.next;

    }
    public static ListNode findTailAfterK(ListNode head, int k) {
        for(int i=0; i< k-1; i++) {
            head = head.next;
            if(head ==null) return null;
        }
        return head;
    }
    public static ListNode reverseKTimes(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        int count = 0;
        while(count < k && current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        return prev;
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
