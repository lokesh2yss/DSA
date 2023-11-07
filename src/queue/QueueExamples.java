package queue;

public class QueueExamples {
    public static void main(String[] args) {

        //QueueUsingOneStack q = new QueueUsingOneStack();
        QueueWithGetMin q = new QueueWithGetMin();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.getMin());
        q.enqueue(5);
        System.out.println(q.getMin());
        q.dequeue();
        q.dequeue();
        System.out.println(q.getMin());
        q.enqueue(4);
        System.out.println(q.getMin());
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.getMin());
        //q.printQueue();
        //System.out.println(q.peek());
        //System.out.println(q.dequeue());



    }
}
