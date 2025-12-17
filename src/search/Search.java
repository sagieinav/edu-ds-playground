package search;

public class Search {
    public int binSearch(int[] data, int target) { // TODO complete this
        int start = 0;
        int end = data.length - 1;
        int mid = (start + end) / 2;
        if (target == data[mid]) {
            return mid;
        }
        return 0;
    }

    public static boolean findSumInArr(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) return true;
            }
        }

        return false;
    }

    public static boolean findSumInSortedArr(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == target) {
                return true;
            } else if (arr[start] + arr[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
