package ex2;

import java.util.Iterator;

public class LinkedListEx2<T> implements Iterable<Node<T>> {
    private Node<T> head;

    public LinkedListEx2() {
        head=null;
    }

    public void addFirst(T data) {
        Node<T> newNode=new Node<T>(null,data);
        if (head!=null){
            newNode.setNext(head);
        }
        head=newNode;
    }

/*    private Node<T> getNodeBefore(T targetValue) { // Using iterator
        if (head == null) return null;
        if (head.getData().equals(targetValue)) return null; // Target node is head. There's nothing before.

        LinkedListEx2Iter<Node<T>> iterator = new LinkedListEx2Iter<>();
        while (iterator.hasNext()) {
            Node<T> currentNode = iterator.next();
            Node<T> nextNode = currentNode.getNext();
            if (nextNode != null && nextNode.getData().equals(targetValue)) {
                return currentNode;
            }
        }

        return null; // Didn't find any matching Node to targetValue
    }*/

    private Node<T> getNodeBefore(T targetValue) {
        // Not using iterator
        if (head == null) return null;
        if (head.getData().equals(targetValue)) return null; // Target node is head. There's nothing before.

        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            Node<T> nextNode = currentNode.getNext();
            if (nextNode.getData().equals(targetValue)) return currentNode;
            currentNode = nextNode;
        }

        return null; // Didn't find any node matching to targetValue
    }

    public boolean hasCycle() {
        LinkedListEx2Iter<Node<T>> slowIterator = new LinkedListEx2Iter<>();
        LinkedListEx2Iter<Node<T>> fastIterator = new LinkedListEx2Iter<>();
        while (fastIterator.hasNext()) {
            // Iterate once for each of them:
            Node<T> currentSlowNode = slowIterator.next();
            Node<T> currentFastNode = fastIterator.next();
            if (fastIterator.hasNext()) currentFastNode = fastIterator.next(); // Iterate again for fast
            else return false; // Cycle is broken
            if (currentSlowNode.equals(currentFastNode)) return true; // Finished a whole cycle
        }
        return false;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Node<T> data : this) {
            buffer.append(data.getData());
            buffer.append(" ");
        }
        return buffer.toString();
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new LinkedListEx2Iter<>();
    }
    private class LinkedListEx2Iter<E> implements Iterator<E> {
        private Node<T> inNode;

        public LinkedListEx2Iter() {
            inNode =  head;
        }

        @Override
        public boolean hasNext() {
            return (inNode != null);
        }

        @Override
        public E next() {
            E prevNode = (E) inNode;
            inNode = inNode.getNext();
            return prevNode;
        }
    }

    public static void main(String[] args) {
        LinkedListEx2<Integer> listy = new LinkedListEx2<>();
        listy.addFirst(4);
        listy.addFirst(3);
        Iterator<Node<Integer>> iter = listy.iterator();
//        while (iter.hasNext()) {
//            System.out.print(iter.next().getData());
//        }
//        System.out.println(listy); // Using toString, which uses the iterator
        for (Node<Integer> node : listy) {
            System.out.print(node.getData() + " ");
        }
        System.out.print("\n");
    }
}

class Node<T> {
    private Node<T> next; // Pointer to the next node's address
    private T data;

    public Node() {
        this.next = null;
        this.data = null;
    }

    public Node(Node<T> next, T data) {
        this.next = next;
        this.data = data;
    }

    public Node<T> getNext() { return next; }

    public void setNext(Node<T> next) { this.next = next; }

    public T getData() { return data; }

    @Override
    public String toString() {
        return "LISTS.Node [next=" +( (next!=null) ? next.getData(): "null"  ) + ", data=" + data + "]";
    }
}