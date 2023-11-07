package linkedlist;

public class KReverseLinkedList {
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
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        Solution sol = new Solution();
        ListNode list = sol.reverseKGroup(n1,4);
        sol.printList(list);
    }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = getLength(head);
        int reverseCount = length/k;
        for(int i=0;i<reverseCount;i++) {
            head = reverse(head,i*k,(i+1)*k);
        }
        return head;
    }
    public int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
    public ListNode reverse(ListNode head, int start, int end) {
        ListNode current = head;
        ListNode prev = null;
        int endCount = start;
        int currentCount = 0;
        while(current !=null) {
            if(currentCount==start) {
                break;
            }
            currentCount++;
            current = current.next;

        }
        while(current != null) {
            if(endCount >= start  && endCount < end) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            if(endCount==end) {
                break;
            }
            endCount++;

        }
        ListNode firstSegment = head;
        while(firstSegment != null && firstSegment.next != null && firstSegment.next.next !=null) {
            firstSegment = firstSegment.next;
        }
        firstSegment.next = null;
        //append current to the end of prev list

        ListNode temp = prev;
        while(temp != null && temp.next != null) {
            temp = temp.next;
        }
        temp.next = current;
        printList(prev);
        if(start>0) {
            ListNode temp1 = head;
            while(temp1.next != null) {
                temp1 = temp1.next;
            }
            temp1.next = prev;
            return head;
        }
        else {
            return prev;
        }
    }
    public void printList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val+"-> ");
            current = current.next;
        }
        System.out.println();
    }
}
