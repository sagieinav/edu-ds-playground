package sort;

public class InsertionSort<T extends Comparable<T>> {
/*    public void insertionSortInitial(int[] data) {
        int temp, j;
        for (int i = 1; i < data.length; i++) {
            j = i;
            while (j > 0 && data[j] < data[j - 1]) {
                temp = data[j];
                data[j] = data[j - 1];
                data[j - 1] = temp;
                j--;
            }
        }
    }*/

    public void sort(T[] data) {
        int j;
        T key;
        for (int i = 1; i < data.length; i++) {
            key = data[i];
            j = i - 1;
            while (j >= 0 && key.compareTo(data[j]) < 0) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }
}
