package linkedlist;

public class ReorderLinkedList {
    public static void main(String[] args) {
        //0 5 1 -9 7 3 -1 -3
        //-8 -6 2 7 -3 7 -9
        ListNode n1 = new ListNode(-8);
        ListNode n2 = new ListNode(-6);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(-3);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(-9);
        //ListNode n8 = new ListNode(-3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        //n7.next = n8;

       ListNode head =  reorderList(n1);
       printList(head);
    }
    public static ListNode reorderList(ListNode head) {
        ListNode slow = head, fast = slow;//slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        ListNode l1 = head;

        ListNode l2 = slow.next;
        slow.next = null;
        printList(l1);
        printList(l2);
        // 3) Reverse the second half, i.e., 5 -> 4
        l2 = reverse(l2);


        //printList(l2);
        ListNode node = new ListNode(0); // Assign dummy Node
        ListNode curr = node;
        while (l1 != null || l2 != null) {
            // First add the element from first list
            if (l1 != null) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }

            // Then add the element from second list
            if (l2 != null) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }

        // Assign the head of the new list to head pointer
        head = node.next;

        // Assign the head of the new list to head pointer

        return head;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
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
