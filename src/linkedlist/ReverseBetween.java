package linkedlist;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(9);
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
        ListNode ans = reverseBetween(n1,1,4);
        printList(ans);
    }
    public static ListNode reverseBetween(ListNode A, int m, int n) {
        ListNode dummy = new ListNode(-1, A);
        ListNode prevLeft = dummy;
        ListNode current = A;
        ListNode prev = null;
        boolean isLeftSideThere = false;
        for(int i=1; i< m; i++) {
            prev = current;
            current = current.next;
            isLeftSideThere = true;
        }
        if(!isLeftSideThere) {
            prevLeft = prev;
        }

        prev=  null;
        printList(current);
        //System.out.println(current.val);
        for(int i=0;i<n-m+1; i++) {
            //System.out.println(current.val);
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        if(prevLeft == null) {
            prevLeft = dummy;
        }
        if(prevLeft != null && prevLeft.next != null) {
            prevLeft.next.next = current;
            prevLeft.next = prev;
        }
        else {
            dummy.next = prev;
        }
        return dummy.next;
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
