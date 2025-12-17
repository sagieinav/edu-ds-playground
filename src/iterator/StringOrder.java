package iterator;

import java.util.Iterator;

public class StringOrder implements Iterable <Character> { // The actual class implements Iterable!
    private String data;

    public StringOrder (String str) {
        this.data = str;
    }

    @Override
    public Iterator<Character> iterator() {
        return new StringOrderIterator();
    }

    private class StringOrderIterator implements Iterator<Character> { // The iterator class implements Iterator!
        private int currentIdx;
        public StringOrderIterator() {
            currentIdx = 0;
        }

        @Override
        public boolean hasNext() {
            if (currentIdx < data.length()) return true;
            else return false;
        }

        @Override
        public Character next() {
            return data.charAt(currentIdx++);
        }
    }
}