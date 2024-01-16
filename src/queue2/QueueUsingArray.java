package queue2;

public class QueueUsingArray {
    int front;
    int rear;
    int[] arr;
    public QueueUsingArray(int n) {
        arr = new int[n];
        this.front = -1;
        this.rear = -1;
    }
    public int peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }
    public int poll() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int a = arr[front];
        if(rear==front) {
            front = -1;
            rear = -1;
        }
        else {
            front++;
        }
        return a;
    }
    public void offer(int a) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty()) {
            front = 0;
        }
        rear++;
        arr[rear] = a;
    }
    public boolean isEmpty() {
        return front==-1;
    }
    public boolean isFull() {
        return rear == arr.length-1;
    }
    public void printQueue() {
        if(isEmpty()) return;
        for(int i=front; i<=rear; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

