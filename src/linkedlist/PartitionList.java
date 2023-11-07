package linkedlist;

public class PartitionList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        //ListNode n7 = new ListNode(7);
        //ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        //n6.next = n7;
        //n7.next = n8;
        printList(n1);
        ListNode ans = partition(n1, 3);
        //printList(ans);
    }
    public static ListNode partition(ListNode A, int B) {
        ListNode dummy1 = new ListNode(-1);
        ListNode newHead = dummy1;
        ListNode dummy2 = new ListNode(-1);
        ListNode dummy2Head = dummy2;
        ListNode current = A;
        while(current != null) {
            if(current.val < B) {
                dummy1.next = current;
                current = current.next;
                dummy1 = dummy1.next;
            }
            else {
                System.out.println(current.val);
                dummy2.next = current;
                current = current.next;
                dummy2 = dummy2.next;
                dummy2.next = null;
            }
        }

        dummy1.next = dummy2Head.next;

        return newHead.next;
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
