package linked_list;

import java.util.List;

public class ReverseList<T> {
    public List<T> reverseList(List<T> data) {
        int size = data.size();
        for (int i = 0; i < size; i++) {
            T first = data.get(i);
            T last = data.get(size - i);
            T temp;
            temp = first;
            first = last;
            last = temp;
        }
        return data;
    }
}
