package queue;

public class QueueUsingArray<T> {
    private int size;
    private T[] arr;
    private int front;
    private int rear;
    public QueueUsingArray(int size) {
        this.size = size;
        front = rear = -1;
        arr = (T[]) new Object[size];;
    }
    public boolean isEmpty() {
        return front == -1;
    }
    public boolean isFull() {
        return rear == size-1;
    }
    public boolean enqueue(T data) {
        if(isFull()) {
            System.out.println("Queue is full, cannot enqueue");
            return false;
        }
        if(isEmpty()) {
            front = 0;
        }
        rear++;
        arr[rear] = data;
        return true;
    }
    public T dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return null;
        }
        T temp = arr[front];
        if(front==rear) {
            front = rear = -1;
            return temp;
        }
        front++;
        return temp;
    }
    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return null;
        }
        return arr[front];
    }
    public void printQueue() {
        if(isEmpty()) return;
        for(int i=front; i<=rear;i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }

}
