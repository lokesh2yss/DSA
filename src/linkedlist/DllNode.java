package linkedlist;

public class DllNode<E> {
    E val;
    DllNode<E> next;
    DllNode<E> prev;
    public DllNode(E val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
