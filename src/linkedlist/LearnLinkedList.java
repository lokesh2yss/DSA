package linkedlist;

public class LearnLinkedList {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(8);
        head.next  = n1;
        n1.next = n2;
        n2.next = n3;
        printLinkedList(head);
        head = insertFirst(4,head);
        insertLast(19,head);

        printLinkedList(head);
        head = deleteFirst(head);
        printLinkedList(head);
        deleteLast(head);
        printLinkedList(head);
        deleteAt(2,head);
        printLinkedList(head);

    }
    public static void printLinkedList(Node<Integer> head) {
        Node<Integer> curr = head;
        while(curr != null) {
            System.out.print(curr.val+"-> ");
            curr = curr.next;
        }
        System.out.println();

    }
    public static Node<Integer> deleteFirst(Node<Integer> head) {
        return head = head.next;
    }
    public static Node<Integer> deleteLast(Node<Integer> head) {
        if(head == null) return null;
        Node<Integer> curr = head;
        Node<Integer> prev = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
    public static void deleteAt(int pos, Node<Integer> head) {
        Node<Integer> curr = head;
        int count = 0;
        while(curr != null) {
            if(count == pos-1) {
                if(curr.next != null && curr.next.next != null) {
                    curr.next = curr.next.next;
                }
                else {
                    return;
                }
            }
            count++;
            curr = curr.next;
        }
    }
    public static Node<Integer> insertFirst(int val, Node<Integer> head) {
        Node<Integer> newNode = new Node<>(val);
        newNode.next = head;
        return newNode;
    }
    public static void insertLast(int val, Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> prev = head;
        while(curr != null) {
            prev = curr;
            curr = curr.next;
        }
        Node<Integer> newNode = new Node<>(val);
        prev.next = newNode;
    }
    public static void insertAt(int pos, int data, Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> newNode = new Node<>(data);
        if(pos==0) {
            newNode.next = curr;
            head = newNode;
            return;
        }
        int count = 0;
        while(curr != null) {
            if(count == pos-1) {
                newNode.next = curr.next;
                curr.next = newNode;
            }
            curr = curr.next;
            count++;

        }

    }
}


