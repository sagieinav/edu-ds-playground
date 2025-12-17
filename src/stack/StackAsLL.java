package stack;

import linked_list.LinkedList;
import linked_list.Node;

public class StackAsLL<T extends Comparable<T>> {
    private final LinkedList<T> list;

    public StackAsLL() {
        list = new LinkedList<>();
    }

    public void push(T value) {
        list.addFirst(value);
    }

    public T pop() {
        // 1. Handle empty stack:
        if (isEmpty()) return null;

        // 2. Get the first item and its' value:
        Node<T> headNode = list.getHead();
        T headValue = headNode.getValue();

        // 3. Pop the first item (node):
        list.delete(headNode);

        // 4. Return the first item (value):
        return headValue;
    }

    public T peek() {
        // 1. Handle empty list:
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
