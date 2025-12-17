package queue;

public class QueueAsArray {
    private int[] data;
    private int start;
    private int end;
    private int size;
    private int capacity;

    public QueueAsArray(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        start = 0;
        end = -1;
        size = 0;
    }


    public boolean enqueue(int value) {
        if (size == capacity) {
            throw new RuntimeException("Queue is empty");
        }
        end = (end + 1) % capacity;
    }

    public boolean dequeue() {
        int value = data[start];
        start = (start + 1) % capacity;
    }
}
