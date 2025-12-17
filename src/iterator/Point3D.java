package iterator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Point3D implements Iterable<Integer> {
//    List<Integer> coordinates = new ArrayList<>();
    private int[] coordinates;

    public Point3D(int x, int y, int z) {
        coordinates = new int[]{x, y, z};
    }

    public int[] getCoordinates() {
        return this.coordinates;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Point3DIterator();
    }

    private class Point3DIterator implements Iterator<Integer> {
        private int currentIdx;

        public Point3DIterator() {
            currentIdx = 0;
        }

        @Override
        public boolean hasNext() {
            return (currentIdx < 3);
        }

        @Override
        public Integer next() {
            return coordinates[currentIdx++];
        }


    }
}
