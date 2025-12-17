package linked_list;

/*public class ReverseLinkedList<T> {
    public LinkedList<T> reverseList(LinkedList<T> data) {
        LinkedList<T> revList = new LinkedList<T>();
        Iterator<LinkedList<T>> iter = data.iterator();

        for (Node<T> node : data) {
            revList.addFirst(node);
        }

        return revList;
    }


    public void reverseListInPlace(LinkedList<T> data) {
        Iterator<LinkedList<T>> iter = data.iterator();

        for (Node<T> node : data) {
            Node<T> prev = node;
            Node<T> current = node.getNext();
            Node<T> next = current.getNext();

            prev.setNext(next.getNext());
            next.setNext(current);
        }

        data.setHead(..);
    }
}*/
