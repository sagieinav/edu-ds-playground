package queue;

public class QueueAsArray {
    // Assuming an array of natural numbers. -1 means empty.
    // Using a circular array.
    private final int[] arr;
    private final int capacity;
    private int size;
    private int idxFirst;
    private int idxLast;


    public QueueAsArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        size = 0;
        idxFirst = 0;
        idxLast = -1;
    }

    public boolean enqueue(int value) {
        // Case 1: stack is full, cant push
        if (isFull())
            return false;

        // Case 2: good to enqueue
        idxLast = (idxLast + 1) % capacity;
        arr[idxLast] = value;
        size++;
        return true;
    }

    public int dequeue() {
        // Case 1: stack is empty
        if (isEmpty())
            return -1;

        // Case 2: good to dequeue
        int itemToDequeue = arr[idxFirst];
        idxFirst = (idxFirst + 1) % capacity;
        size--;
        return itemToDequeue;
    }

    public int peek() {
        // Case 1: stack is empty
        if (isEmpty())
            return -1;

        // Case 2: good to peek
        return arr[idxFirst];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
