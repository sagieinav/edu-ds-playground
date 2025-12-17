package queue;

import linked_list.LinkedList;
import linked_list.Node;

public class QueueAsLL<T extends Comparable<T>> {
    private final LinkedList<T> list;

    public QueueAsLL() {
        list = new LinkedList<>();
    }

    public void enqueue(T value) {
        list.addLast(value);
    }

    public T dequeue() {
        // 1. Handle empty queue:
        if (isEmpty()) return null;

        // 2. Get the head node and its' value:
        Node<T> headNode = list.getHead();
        T headValue = headNode.getValue();

        // 3. Dequeue the first item (node):
        list.delete(headNode);

        // 4. Return the first item (value):
        return headValue;
    }

    public T peek() {
        // 1. Handle empty queue:
        if (isEmpty()) return null;

        // 2. Get the first item's value:
        T headValue = list.getHead().getValue();

        // 3. Return the first item (value):
        return headValue;
    }

    public boolean isEmpty() {
        return (list.getHead() == null);
    }

    public int getSize() {
        return list.getSize();
    }
}
