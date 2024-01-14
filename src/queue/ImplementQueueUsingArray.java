package queue;

public class ImplementQueueUsingArray {
    int front;
    int rear;
    int arr[] = new int[100005];

    ImplementQueueUsingArray() {
        front = 0;
        rear = 0;
    }

    void push(int a) {
        arr[rear++] = a;
    }

    int pop() {
        if (front == rear) return -1;
        return arr[front++];
    }
}
