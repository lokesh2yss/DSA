package queue2;

public class QueueUsingLinkedList {
    ListNode front;
    ListNode rear;
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int a) {
            this.val = a;
        }
    }
    public void offer(int a) {
        ListNode node = new ListNode(a);
        if(rear == null) {
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        rear = rear.next;
    }
    public int poll() {
        if(front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int a = front.val;
        if(front == rear) {
            front = rear = null;
        }else {
            front = front.next;
        }
        return a;
    }
    public int peek() {
        if(front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.val;
    }
    public void printQueue() {
        ListNode node = front;
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

}

