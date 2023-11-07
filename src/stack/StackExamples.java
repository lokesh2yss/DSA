package stack;

public class StackExamples {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        printStack(stack);
    }
    public static void printStack(StackUsingLinkedList stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+ " ");
        }
        System.out.println();
    }
}
