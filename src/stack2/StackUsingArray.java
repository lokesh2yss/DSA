package stack2;

public class StackUsingArray {
    int[] a;
    int top;
    int size;
    int capacity;
    public StackUsingArray(int capacity) {
        a = new int[capacity];
        top = -1;
        size = 0;
        this.capacity = capacity;
    }
    public boolean push(int x) {
        if(size == capacity) {
            return false;
        }
        a[++top] = x;
        size++;
        return true;
    }
    public int pop() {
        if(size==0) return -1;
        int x = a[top--];
        size--;
        return x;
    }
}
