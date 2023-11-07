package stack;

public class StackUsingLinkedList {
    class StackNode {
        int data;
        StackNode next;
        StackNode(int data) {
            this.data = data;
            next = null;
        }
    }
    StackNode top;
    public boolean isEmpty() {
        return top==null;
    }
    public void push(int data) {
        StackNode node = new StackNode(data);
        node.next = top;
        top = node;
    }
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int temp = top.data;
        top = top.next;
        return temp;
    }
}
