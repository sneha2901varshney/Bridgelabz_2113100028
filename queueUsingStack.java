package AssignmentStackQueue;

import java.util.* ;

public class queueUsingStack {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public queueUsingStack() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    public void enqueue(int item) {
        stackEnqueue.push(item);
    }

    public int dequeue() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                System.out.print("Queue is empty");
            }
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    public int peek() {
        if (stackDequeue.isEmpty()) {
            if (stackEnqueue.isEmpty()) {
                System.out.print("Queue is empty");
            }
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.peek();
    }

    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public static void main(String[] args) {
        queueUsingStack queue = new queueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
    }
}

