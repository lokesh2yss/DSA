package queue;

public class ImplementQueueUsingLinkedList {
    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }

    QueueNode front;
    QueueNode rear;

    void push(int a) {
        QueueNode newNode = new QueueNode(a);
        if(rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int pop() {
        if(front == null) {
            return -1;
        }
        int temp = front.data;
        if(front == rear) {
            front = rear = null;
            return temp;
        }
        front = front.next;
        return temp;
    }
}
