package linkedlist;

public class RotateList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        /*ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(3);
        ListNode n8 = new ListNode(2);
        ListNode n9 = new ListNode(1);
        ListNode n10 = new ListNode(0);*/
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        /*n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;*/
        printList(n1);
        ListNode ans = rotateList(n1,2);
        printList(ans);
    }
    public static ListNode rotateList(ListNode A, int B) {
        int n = getLength(A);
        B = B%n;
        int fromStart = n -B;
        //traverse right upto n-B points
        ListNode current = A;
        ListNode prev = null;
        for(int i=0;i<n-B; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        ListNode newHead = current;
        while(current.next != null) {
            current = current.next;
        }
        current.next = A;
        return newHead;
    }
    public static int getLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
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
