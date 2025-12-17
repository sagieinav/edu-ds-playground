package sort;
import linked_list.Node;
import linked_list.LinkedList;

public class MergeTwoSortedLinkedLists<T extends Comparable<T>> {

    public Node<T> merge(LinkedList<T> left, LinkedList<T> right) {
        // This merge is in-place, and it returns the head node of the merged list

        // Start from first node of both lists:
        Node<T> leftNode = left.getHead();
        Node<T> rightNode = right.getHead();

        // Create a (dummy) head node for the new merged list:
        Node<T> dummyHead = new Node<>(); // empty node
        Node<T> currentNode = dummyHead;

        while (leftNode != null && rightNode != null) {
            if (leftNode.compareTo(rightNode) <= 0) { // left <= right
                currentNode.setNext(leftNode);
                leftNode = leftNode.getNext();
            }
            else { // left > right
                currentNode.setNext(rightNode);
                rightNode = rightNode.getNext();
            }
            currentNode = currentNode.getNext();
        }

        // One of the lists has leftovers. Handle it:
        if (leftNode != null) {
            currentNode.setNext(leftNode);
        }
        else {
            currentNode.setNext(rightNode);
        }

        return dummyHead.getNext();
    }

    public Node<T> mergeRec(Node<T> leftNode, Node<T> rightNode) {
        Node<T> currentNode = null;

        // Stop conditions: one (or more) of the lists has finished being iterated
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;

        if (leftNode.compareTo(rightNode) <= 0) {
            currentNode = leftNode;
            currentNode.setNext(mergeRec(leftNode.getNext(), rightNode)); // Call again with left node gone
        }
        else {
            currentNode = rightNode;
            currentNode.setNext(mergeRec(leftNode, rightNode.getNext())); // Call again with right node gone
        }
        return currentNode;
    }
}
