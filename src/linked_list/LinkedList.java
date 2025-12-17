package linked_list;
import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<Node<T>> {
    private Node<T> head;
    private int size; // Keeping track of the size, though all methods will NOT use this var, for learning purposes

    public LinkedList() {
        head = null;
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getNext(T targetValue) {
        Node<T> nextNode = null;
        LinkedListIterator<Node<T>> iterator = new LinkedListIterator<>();

        while (iterator.hasNext()) {
            Node<T> currentNode = iterator.next();
            if (currentNode.getValue().equals(targetValue)) nextNode = currentNode.getNext();
        }

        return nextNode;
    }

    public boolean insert(T targetValue, T newValue) {
        // 1. Find the node of `targetValue`
        Node<T> targetNode = findNode(targetValue);
        if (targetNode == null) return false;

        /* 2. Create the new node
        + 3. Point the new (inserted) node to target's next */
        Node<T> nextNode = targetNode.getNext();
        Node<T> newNode = new Node(nextNode, newValue);

        // 4. Point target's next to the new (inserted) node
        targetNode.setNext(newNode);

        // 5. Increase the size tracker and return true (op successful)
        size++;
        return true;
    }

    public boolean insert(Node<T> targetNode, T newValue) {
        // 2. Create the new node
        // + 3. Point the new (inserted) node to target's next
        Node<T> nextNode = targetNode.getNext();
        Node<T> newNode = new Node(nextNode, newValue);

        // 4. Point target's next to the new (inserted) node
        targetNode.setNext(newNode);

        // 5. Increase the size tracker and return true (op successful)
        size++;
        return true;
    }

    public Node<T> findNode(T targetValue) {
        Node<T> targetNode = null;
        LinkedListIterator<Node<T>> iterator = new LinkedListIterator<>();

        while (iterator.hasNext()) {
            Node<T> currentNode = iterator.next();
            if (currentNode.getValue().equals(targetValue)) targetNode = currentNode;
        }

        return targetNode;
    }

    public void addFirst(Node<T> newNode) {
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addFirst(T newValue) {
        Node<T> newNode = new Node<T>(null, newValue);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public Node<T> findLast() { // More efficient, iterator is not needed here
        if (head == null) return null; // Handle empty list. equivalent to (size == 0)

        Node<T> lastNode = head; // Assume first is last for a list of size 1
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }

        return lastNode;
    }

    public Node<T> findMiddle() { // Without using our size var
        if (head == null) return null; // Handle empty list. equivalent to (size == 0)
        Iterator<Node<T>> slowIterator = new LinkedListIterator<>();
        Iterator<Node<T>> fastIterator = new LinkedListIterator<>();
        Node<T> middleNode = null;
        while (fastIterator.hasNext()) {
            // slow iterates once, fast iterates twice. when fast finishes, slow will be middle node
            middleNode = slowIterator.next();
            Node<T> currentFastNode = fastIterator.next();
            if (fastIterator.hasNext()) currentFastNode = fastIterator.next();
        }
        return middleNode;
    }

    public Node<T> findMiddle(Node<T> head) {
        if (head == null) return null; // Handle empty list. equivalent to (size == 0)
        Node<T> slowNode = head;
        Node<T> fastNode = head.getNext();
        while (fastNode != null) {
            // slow iterates once, fast iterates twice. when fast finishes, slow will be middle node
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext();
            if (fastNode != null) fastNode = fastNode.getNext();
        }
        return slowNode;
    }

    public void addLast(Node<T> newNode) {
        if (head == null) addFirst(newNode); // Handle empty list. equivalent to (size == 0)
        else {
            Node<T> lastNode = findLast();
            lastNode.setNext(newNode);
            newNode.setNext(null); // Ensure it doesn't point to anything
            size++;
        }
    }

    public void addLast(T newValue) {
        if (head == null) addFirst(newValue); // Handle empty list. equivalent to (size == 0)
        else {
            Node<T> newNode = new Node<T>(null, newValue);
            Node<T> lastNode = findLast();
            lastNode.setNext(newNode);
            size++;
        }
    }
    
    public boolean delete(T targetValue) {
        if (head == null) return false; // Handle empty list

        Node<T> prevNode = getPrev(targetValue);
        if (prevNode == null) { // Target node is head
            head = head.getNext(); // if/when size is 1, head will just be set to null
        }
        else {
            Node<T> targetNode = prevNode.getNext();
            Node<T> nextNode = targetNode.getNext();
            prevNode.setNext(nextNode);
        }
        size--;
        return true;
    }

    public boolean delete(Node<T> targetNode) {
        if (head == null) return false; // Case 1: empty list
        if (targetNode == head) { // Case 2: target is head
            head = targetNode.getNext(); // if/when size is 1, head will just be set to null
        }
        else { // Case 3: Target is not head, size > 1
            Node<T> prevNode = getPrev(targetNode);
            Node<T> nextNode = targetNode.getNext(); // Might be null
            prevNode.setNext(nextNode);
        }
        size--;
        return true;
    }

    public Node<T> getPrev(Node<T> targetNode) {
        if (head == null) return null;
        if (targetNode == head) return null;

        LinkedListIterator<Node<T>> iterator = new LinkedListIterator<>();
        while (iterator.hasNext()) {
            Node<T> currentNode = iterator.next();
            Node<T> nextNode = currentNode.getNext();
            if (nextNode.equals(targetNode)) {
                return currentNode;
            }
        }

        return null; // Didn't find any matching Node to targetValue
    }

    private Node<T> getPrev(T targetValue) {
        // Not using iterator
        if (head == null) return null;
        if (head.getValue().equals(targetValue)) return null; // Target node is head. There's nothing before.

        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            Node<T> nextNode = currentNode.getNext();
            if (nextNode.getValue().equals(targetValue)) {
                return currentNode;
            }
            currentNode = nextNode;
        }

        return null; // Didn't find any matching Node to targetValue
    }

    public int getSize() {
        return this.size;
//        // In case we didn't have a dedicated size variable:
//        Iterator<Node<T>> iterator = iterator();
//        int size = 0;
//        while (iterator.hasNext()) {
//            size++;
//            iterator.next();
//        }
//        return size;
    }

    public boolean hasCycle() {
        Iterator<Node<T>> slowIterator = new LinkedListIterator<>();
        Iterator<Node<T>> fastIterator = new LinkedListIterator<>();
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
        StringBuilder sb = new StringBuilder();
        for (Node<T> data : this) {
            sb.append(data.getValue())
            .append(" ");
        }
        return sb.toString();
    }


// ===== ITERATOR =====

    @Override
    public Iterator<Node<T>> iterator() {
        return new LinkedListIterator<>();
    }

    private class LinkedListIterator<E> implements Iterator<E> {
        private Node<T> currentNode;
        private int gone;

        public LinkedListIterator() {
            currentNode = head;
            gone = 0;
        }

        @Override
        public boolean hasNext() {
//            return gone < size;
            return (currentNode != null); // This check is preferred
        }

        @Override
        public E next() {
            E prevNode = (E) currentNode;
            currentNode = currentNode.getNext(); // Advance the iterator to the next node
            gone++; // Number of elements already iterated
            return prevNode; // We have to return the prev node
        }
    }
}

