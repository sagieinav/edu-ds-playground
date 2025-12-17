package queue;

import stack.StackAsLL;

public class QueueAsTwoStacks<T extends Comparable<T>> {
    private final StackAsLL<T> inStack;
    private final StackAsLL<T> outStack;

    public QueueAsTwoStacks() {
        inStack = new StackAsLL<>();
        outStack = new StackAsLL<>();
    }

    public void enqueue(T newValue) {
        inStack.push(newValue);
    }

    public T dequeue() {
        if (outStack.isEmpty()) refillOutStack();
        return outStack.pop();
    }

    private void refillOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public T peek() {
        if (outStack.isEmpty()) refillOutStack();
        return outStack.peek();
    }

    public int getSize() {
        return inStack.getSize() + outStack.getSize();
    }
}
