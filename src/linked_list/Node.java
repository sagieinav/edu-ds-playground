package linked_list;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private Node<T> next; // Pointer to the next node's address
    private T value;

    public Node() {
        this.next = null;
        this.value = null;
    }

    public Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public Node<T> getNext() { return next; }

    public void setNext(Node<T> next) { this.next = next; }

    public T getValue() { return value; }

    @Override
    public String toString() {
        return "LISTS.Node [next=" +( (next!=null) ? next.getValue(): "null"  ) + ", data=" + value + "]";
    }

    @Override
    public int compareTo(Node<T> other) {
        return value.compareTo(other.getValue());
    }
}
