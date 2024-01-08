package stack2;

import java.util.LinkedList;

public class StackUsingLinkedList {
    class StackNode {
        int val;
        StackNode next;
        public StackNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    StackNode head;
    int top;
    public StackUsingLinkedList() {
        head = null;
        top = -1;
    }
    public void push(int x) {
        StackNode node = new StackNode(x);
        if(head == null) {
            head = node;
        }
        else {
            node.next = head;
            head = node;
        }
    }
    public int pop() {
        if(head == null) {
            return -1;
        }
        int x = head.val;
        head = head.next;
        return x;
    }
}
