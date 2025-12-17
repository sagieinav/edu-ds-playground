package sort;
import linked_list.Node;
import linked_list.LinkedList;

public class MergeSort<T extends Comparable<T>> {

    public void sort(LinkedList<T> data) {
        Node<T> originHead = data.getHead();
        // Stop condition:
        if (originHead == null || originHead.getNext() == null){
            return; // List is already sorted (size <= 1)
        }

        // Call the recursive sort method on the original list's head
        Node<T> finalSortedHead = sort(originHead);

        // Update the original list's head with the fully sorted head
        data.setHead(finalSortedHead);
    }

    private Node<T> sort(Node<T> listHead) {
        // Stop condition: List is already sorted (size <= 1)
        if (listHead == null || listHead.getNext() == null){
            return listHead;
        }

        // Split the list into two halves:
        Node<T> middleNode = findMiddle(listHead);
        Node<T> rightListHead = middleNode.getNext();
        middleNode.setNext(null); // Cut in the middle

        // Recursively sort the two halves:
        Node<T> sortedLeftHead = sort(listHead);
        Node<T> sortedRightHead = sort(rightListHead);

        // Merge the sorted halves:
        Node<T> sortedListHead = mergeRec(sortedLeftHead, sortedRightHead);
        return sortedListHead;
    }

    private Node<T> findMiddle(Node<T> head) {
        if (head == null || head.getNext() == null) return head; // Handle size <= 1
        Node<T> slow = head;
        Node<T> fast = head;
        // Gotta make sure we can iterate fast by 2. They always iterate together! slow 1, fast 2
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }


    private Node<T> merge(LinkedList<T> left, LinkedList<T> right) {
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

    private Node<T> mergeRec(Node<T> leftNode, Node<T> rightNode) {
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
