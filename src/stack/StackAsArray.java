package stack;

public class StackAsArray {
    // Assuming an array of natural numbers. -1 means empty.
    private final int[] arr;
    private final int capacity;
    private int size;


    public StackAsArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        size = 0;
    }

    public boolean push(int value) {
        // Case 1: stack is full, cant push
        if (isFull())
            return false;

        // Case 2: good to push
        arr[size] = value;
        size++;
        return true;
    }

    public int pop() {
        // Case 1: stack is empty
        if (isEmpty())
            return -1;

        // Case 2: good to pop
        int first = arr[size - 1];
        size--;
        return first;
    }

    public int peek() {
        // Case 1: stack is empty
        if (isEmpty())
            return -1;

        // Case 2: good to peek
        return arr[size - 1];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}

