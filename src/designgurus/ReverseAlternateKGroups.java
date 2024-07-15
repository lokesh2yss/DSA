package designgurus;

public class ReverseAlternateKGroups {
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
        ListNode result = reverse(n1,3);
        printList(result);

    }

    public static ListNode reverse(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        for(int i=0; i< k && current != null; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if(head != null) head.next = current;
        for(int i=0;i<k-1 && current != null;i++) {
            current = current.next;
            //if(current == null) break;
        }
        if(current != null) {
            current.next = reverse(current.next, k);
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
