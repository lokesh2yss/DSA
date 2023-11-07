package linkedlist;

public class LearnDoublyLinkedList {
    public static void main(String[] args) {
        DllNode<Integer> head = new DllNode<>(1);
        DllNode<Integer> n1 = new DllNode<>(2);
        DllNode<Integer> n2 = new DllNode<>(5);
        DllNode<Integer> n3 = new DllNode<>(8);

        head.next = n1;
        n1.prev = head;

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        printDoublyLinkedList(head);
        head = deleteAt(2,head);
        printDoublyLinkedList(head);
    }
    public static DllNode<Integer> deleteAt(int pos, DllNode<Integer> head) {
        DllNode<Integer> curr = head;
        if(pos == 0) {
            curr = curr.next;
            curr.prev = null;
            return curr;
        }
        for(int i = 0; i< pos-1; i++) {
            curr = curr.next;
        }
        if(curr.next.next == null) {
            //deleting last node
            curr.next = null;
            return head;
        }
        curr.next = curr.next.next;
        curr.next.prev = curr;
        return head;
    }
    public static DllNode<Integer> insertAt(int pos, int val, DllNode<Integer> head) {
        DllNode<Integer> curr = head;
        DllNode<Integer> newNode = new DllNode<>(val);
        if(pos ==0) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        for(int i=0;i<pos-1;i++) {
            curr = curr.next;
        }
        //adding at last
        if(curr.next == null) {
            curr.next = newNode;
            newNode.prev = curr;
            return head;
        }
        newNode.next = curr.next;
        curr.next.prev = newNode;

        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }
    public static void printDoublyLinkedList(DllNode<Integer> head) {
        DllNode<Integer> curr = head;
        while(curr != null) {
            System.out.print(curr.val + "-> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
