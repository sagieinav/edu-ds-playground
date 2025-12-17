package sort;

public class SelectionSort<T extends Comparable<T>> {
    public void sort(T[] data) {
        int min_idx;
        T temp;
        for (int i = 0; i < data.length - 1; i++) {
            min_idx = i;
            for (int j = i; j < data.length; j++) {
                if (data[j].compareTo(data[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            temp = data[i];
            data[i] = data[min_idx];
            data[min_idx] = temp;
        }
    }
}
