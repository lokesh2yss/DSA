package designgurus;

import java.util.EmptyStackException;

public class StackUsingArray {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(5);
        //System.out.println(stack.pop());
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
    public static void printStack(MyStack stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
}

class MyStack<T> {
    int top = -1;
    Object[] arr;
    int size;
    public MyStack(int size) {
        this.size = size;
        arr = new Object[size];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == size-1;
    }
    public boolean push(T val) {
        if(isFull()) return false;
        top++;
        arr[top] = val;
        return true;
    }
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T val = (T) arr[top];
        top--;
        return val;
    }
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) arr[top];
    }
}
