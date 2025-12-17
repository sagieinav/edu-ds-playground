package sort;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

public class QuickSort<T extends Comparable<T>> {

    public List<T> optimisedSort(List<T> data) {
        if (data == null || data.isEmpty()) return data;
        optimisedSort(data, 0, data.size() - 1); // Sorts the big array to groups of 128-sized sub-arrays
        insertionSort(data); // Sorts the nearly-sorted big array
        return data;
    }

    private void optimisedSort(List<T> data, int low, int high) {
        if (high - low > 128) {
            // Perform partition and get pivot's index
            int pivotIdx = partition(data, low, high);

            // Recursively quicksort the left sub-array
            optimisedSort(data, low, pivotIdx - 1);

            // Recursively quicksort the right sub-array
            optimisedSort(data, pivotIdx + 1, high);
        }
    }

    private void insertionSort(List<T> data) {
        int j;
        T key;
        for (int i = 1; i < data.size(); i++) {
            key = data.get(i);
            j = i - 1;
            while (j >= 0 && key.compareTo(data.get(j)) < 0) {
                data.set(j + 1, data.get(j));
                j--;
            }
            data.set(j + 1, key);
        }
    }


    public List<T> sort(List<T> data) {
        if (data == null || data.isEmpty()) return data;
        sort(data, 0, data.size() - 1);
        return data;
    }

    private void sort(List<T> data, int low, int high) {
        if (low < high) {
            // Perform partition and get pivot's index
            int pivotIdx = partition(data, low, high);

            // Recursively quicksort the left sub-array
            sort(data, low, pivotIdx - 1);

            // Recursively quicksort the right sub-array
            sort(data, pivotIdx + 1, high);
        }
    }

    private int partition(List<T> data, int low, int high) {
        T pivot = data.get(low);
        int left = low;
        int right = high;

        // Loop until the pointers cross
        while (left < right) {
            // Move 'left' pointer forward while item <= pivot. Ensure left pointer doesn't go out of bound
            while (left < high && data.get(left).compareTo(pivot) <= 0 ) {
                left++;
            }

            // Move 'right' pointer backward while item > pivot
            while (data.get(right).compareTo(pivot) > 0) {
                right--;
            }

            // Swap (as long as pointers haven't crossed yet):
            if (left < right) {
                Collections.swap(data, left, right);
            }
        }

        // Finally, put the pivot in its place (the cross point of the two pointers)
        data.set(low, data.get(right));
        data.set(right, pivot);

        return right; // Return the pivot's new index (its final location)
    }

    public T[] sort(T[] data) {
        if (data == null) return data;
        sort(data, 0, data.length - 1);
        return data;
    }

    public void sort(T[] data, int low, int high) {
        if (low < high) {
            // Perform partition and get pivot's index
            int pivotIdx = partition(data, low, high);

            // Recursively quicksort the left sub-array
            sort(data, low, pivotIdx - 1);

            // Recursively quicksort the right sub-array
            sort(data, pivotIdx + 1, high);
        }
    }

    private int partition(T[] data, int low, int high) {
        T pivot = data[low];
        int left = low;
        int right = high;

        // Loop until the pointers cross
        while (left < right) {
            // Move 'left' pointer forward while item <= pivot. Ensure left pointer doesn't go out of bound
            while (left < high && data[left].compareTo(pivot) <= 0) {
                left++;
            }

            // Move 'right' pointer backward while item > pivot:
            while (right > low && data[right].compareTo(pivot) > 0) {
                right--;
            }

            // Swap (as long as pointers haven't crossed yet):
            if (left < right) {
                swap(data, left, right);
            }
        }

        // Finally, put the pivot in its place (the cross point of the two pointers)
        data[low] = data[right];
        data[right] = pivot;
        return right; // Return the pivot's new index (its final location)
    }


    private void swap(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
