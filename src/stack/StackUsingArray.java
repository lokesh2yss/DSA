package stack;

public class StackUsingArray {
    private int top;
    private int[] arr;
    public StackUsingArray(int size) {
        arr = new int[size];
        top = -1;
    }
    public boolean isEmpty() {
        return top==-1;
    }
    public boolean isFull() {
        return top == arr.length-1;
    }
    public boolean push(int data) {
        if(isFull()) {
            return false;
        }
        top++;
        arr[top] = data;
        return true;
    }
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        int temp = arr[top];
        top--;
        return temp;
    }
    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        return arr[top];
    }

}
