package designgurus;

import java.util.EmptyStackException;

public class StackUsingLinkedList {
    public static void main(String[] args) {
        LLStack<Integer> stack = new LLStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        printStack(stack);
    }
    public static void printStack(LLStack<Integer> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
}

class Node<T> {
    T val;
    Node<T> next;
    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}
class LLStack<T> {
    private Node<T>  head = null;
    public boolean isEmpty() {
        return head == null;
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> node = head;
        head = head.next;
        return (T) node.val;
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) head.val;
    }
    public void push(T val) {
        Node<T> node = new Node<T>(val);
        node.next = head;
        head = node;
    }
}
