package linkedlist;

public class Node<E> {
    E val;
    Node<E> next;

    public Node(E val) {
        this.val = val;
        this.next = null;
    }
}
