package sort;

public class BubbleSort<T extends Comparable<T>>  {
    public void sort(T[] data) { // Generic BubbleSort
        int n = data.length;
        T temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0 ) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
/*    public void bubbleSortFlag(int[] data) {
        int temp;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i + 1]) {
                    temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    flag = true;
                }
            }
        }
    }*/

/*    public void bubbleSort(int[] data) {
        int n = data.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }*/
}
