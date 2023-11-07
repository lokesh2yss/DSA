package linkedlist;

import java.util.ArrayList;
import java.util.Objects;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(10000);
        ListNode n2 = new ListNode(1000);
        ListNode n3 = new ListNode(100);
        ListNode n4 = new ListNode(10);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(10);
        ListNode n7 = new ListNode(100);
        ListNode n8 = new ListNode(1000);
        ListNode n9 = new ListNode(10000);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        Solution1 sol = new Solution1();
        System.out.println(sol.isPalin(n1));

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() { val = 0; next = null; }
    ListNode(int val) { this.val = val; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution1 {
    public int isPalin(ListNode A) {
        printList(A);
        ArrayList<Integer> list1 = new ArrayList<>();
        ListNode temp = A;
        while(temp !=null) {
            list1.add(temp.val);
            temp = temp.next;
        }

        ListNode B = reverse(A);
        printList(B);
        ArrayList<Integer> list2 = new ArrayList<>();
        temp = B;
        while(temp !=null) {
            list2.add(temp.val);
            temp = temp.next;
        }
        for(int i=0;i<list2.size();i++) {
            System.out.print(list2.get(i) + " ");
        }
        for(int i=0;i< list1.size(); i++) {
            System.out.println(list1.get(i) +" ans B "+ list2.get(i));
            if(!Objects.equals(list1.get(i), list2.get(i))) {
                return 0;
            }
        }
        return 1;
      /*
      ListNode current1 = A;
      ListNode current2 = B;
      while(current1 != null && current2 != null) {
        //System.out.print(current1.val + " "+ current2.val);
        //System.out.println();
        if(current1.val != current2.val) {
          //early return false;
          return 0;
        }
        current1 = current1.next;
        current2 = current2.next;
      }
      return 1;
      */
    }
    public void printList(ListNode head) {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val+"-> ");
            current = current.next;
        }
        System.out.println();
    }
    public ListNode reverse(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
