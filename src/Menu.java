import ex1.Palindrome;
import ex1.SortMatrix;
import ex1.StringSort;
import iterator.Point3D;
import iterator.StringOrder;
import linked_list.LinkedList;
import sort.BubbleSort;
import sort.InsertionSort;
import sort.QuickSort;
import sort.SelectionSort;
import sort.MergeSort;
import utilities.Scan;
import well_formed_formula.LogicWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Menu<T> {
    boolean cameFromSubMenu;
    // Sort algorithms testcases:
    Integer[] unsortedNumbers = {8, 5, 19, 2, 100, 84, 22, 1};
    Character[] unsortedChars = {'a', 'Z', 'd', 'D', 'A', 'z'};


    public void runMenu() {
        int choice;
        do {
            cameFromSubMenu = false;
            System.out.println("\n===== Main Menu =====" +
                    "\n1) Run a sorting algorithm" +
                    "\n2) Perform tests for exercise 1" +
                    "\n3) String iterator" +
                    "\n4) Point 3D Iterator" +
                    "\n5) Perform isWFF Checks (Math Logic Exe)" +
                    "\n0) Exit");
            System.out.print("\nPlease enter your choice, 0 to exit: ");
            choice = Scan.nextInt();
            switch (choice) {
                case 0 -> System.out.println("Bye!");
                case 1 -> sortSubMenu();
                case 2 -> ex1SubMenu();
                case 3 -> testStringIterator();
                case 4 -> testPoint3DIterator();
                case 5 -> testIsWff();

                default -> System.out.println("Invalid input");
            }
            System.out.print("\nPress any key to show menu again ");
            if (!cameFromSubMenu) Scan.nextLine(); // for stalling menu appearance
        } while (choice != 0);
    }

    public void sortSubMenu() {
        int choice;
        System.out.println("\n===== Sorting Algorithms Menu =====" +
                "\n1) Perform a Bubble Sort" +
                "\n2) Perform a Selection Sort" +
                "\n3) Perform an Insertion Sort" +
                "\n4) Perform a Quick Sort" +
                "\n5) Perform a Merge Sort" +
                "\n0) Go back to main menu");
        System.out.print("\nPlease enter your choice, 0 to go back to main menu: ");
        choice = Scan.nextInt();

        switch (choice) {
            case 0 -> cameFromSubMenu = true;
            case 1 -> testBubbleSort();
            case 2 -> testSelectionSort();
            case 3 -> testInsertionSort();
            case 4 -> testQuickSort();
            case 5 -> testMergeSort();
        }
    }

    public void ex1SubMenu() {
        int choice;
        System.out.println("\n===== Exercise 1 Sub Menu =====" +
                "\n1) Perform Palindrome Checks (Ex1.1)" +
                "\n2) Perform StringSort Checks (Ex1.2)" +
                "\n3) Perform MatrixSort Checks (Ex1.3)" +
                "\n0) Go back to main menu");
        System.out.print("\nPlease enter your choice, 0 to go back to main menu: ");
        choice = Scan.nextInt();

        switch (choice) {
            case 0 -> cameFromSubMenu = true;
            case 1 -> testIsPalindrome();
            case 2 -> testStringSort();
            case 3 -> testMatrixSort();
        }
    }

    private void testBubbleSort() {
        BubbleSort bubbleSorter = new BubbleSort();

        Integer[] intArr = Arrays.copyOf(unsortedNumbers, unsortedNumbers.length);
        printUnsorted(intArr);
        bubbleSorter.sort(intArr);
        System.out.println("Bubble sorted: " + Arrays.toString(intArr));

        Character[] chArr = Arrays.copyOf(unsortedChars, unsortedChars.length);
        printUnsorted(chArr);
        bubbleSorter.sort(chArr);
        System.out.println("Bubble sorted: " + Arrays.toString(chArr));
    }

    private void testSelectionSort() {
        SelectionSort selectionSorter = new SelectionSort();

        Integer[] intArr = Arrays.copyOf(unsortedNumbers, unsortedNumbers.length);
        printUnsorted(intArr);
        selectionSorter.sort(intArr);
        System.out.println("Selection sorted: " + Arrays.toString(intArr));

        Character[] chArr = Arrays.copyOf(unsortedChars, unsortedChars.length);
        printUnsorted(chArr);
        selectionSorter.sort(chArr);
        System.out.println("Bubble sorted: " + Arrays.toString(chArr));
    }

    private void testInsertionSort() {
        InsertionSort insertionSorter = new InsertionSort();

        Integer[] intArr = Arrays.copyOf(unsortedNumbers, unsortedNumbers.length);
        printUnsorted(intArr);
        insertionSorter.sort(intArr);
        System.out.println("Insertion sorted: " + Arrays.toString(intArr));

        Character[] chArr = Arrays.copyOf(unsortedChars, unsortedChars.length);
        printUnsorted(chArr);
        insertionSorter.sort(chArr);
        System.out.println("Bubble sorted: " + Arrays.toString(chArr));
    }

    private void testQuickSort() {
        QuickSort quickSorter = new QuickSort();

        Integer[] intArr = Arrays.copyOf(unsortedNumbers, unsortedNumbers.length);
        List<Integer> integerList = new ArrayList<>(Arrays.asList(intArr));
        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(intArr));

        printUnsorted(intArr);


        quickSorter.sort(intArr);
        System.out.println("Quick sorted array: " + Arrays.toString(intArr));

        quickSorter.sort(integerList);
        System.out.println("Quick sorted list: " + integerList);

        quickSorter.optimisedSort(integerList2);
        System.out.println("Optimised quick sorted list: " + integerList2);
    }

    private void testMergeSort() {
        LinkedList<Integer> intLinkedList = new LinkedList<Integer>();
        intLinkedList.addFirst(4);
        intLinkedList.addFirst(2);
        intLinkedList.addFirst(5);
        intLinkedList.addFirst(1);
        intLinkedList.addFirst(3);
        printUnsorted(intLinkedList);
        MergeSort<Integer> mergeSorter = new MergeSort<>();
        mergeSorter.sort(intLinkedList);
        System.out.println("Sorted List: " + intLinkedList);
    }

    private void testIsPalindrome() {
        Palindrome palChecker = new Palindrome();
        System.out.println(palChecker.isPalindrome(121));
        System.out.println(palChecker.isPalindrome(1000110001));
        System.out.println(palChecker.isPalindrome(2047557402));
        System.out.println(palChecker.isPalindrome(1000021));
        System.out.println(palChecker.isPalindrome(1001));
        System.out.println(palChecker.isPalindrome(101));
    }

    private void testStringSort() {
        StringSort stringSorter = new ex1.StringSort();
        String testStr = "zZaAC";
        String sortedStr = stringSorter.sortString(testStr);
        System.out.println(sortedStr);
    }

    private void testMatrixSort() {
        // Matrix sort checks:
        SortMatrix mSorter = new SortMatrix();
        int[][] matrix = {
                {5, 2, 3},
                {4, 1, 6},
                {7, 8, 0}
        };

        System.out.println("Unsorted matrix: ");
        mSorter.printMatrix(matrix);

        mSorter.sortMatrixDiagonal(matrix);
        System.out.println("Sorted matrix: ");
        mSorter.printMatrix(matrix);
    }

    private void testStringIterator() {
        StringOrder strExample = new StringOrder("Koala");

        Iterator<Character> iter1 = strExample.iterator();
        System.out.println("Iterate using while hasNext:");
        while (iter1.hasNext()) {
            System.out.print(iter1.next());
        }

        Iterator<Character> iter2 = strExample.iterator();
        System.out.println("\nIterate using for each:");
        for (Character c : strExample) {
            System.out.print(iter2.next());
        }
        System.out.print("\n");
    }

    private void testPoint3DIterator() {
        Point3D data = new Point3D(3, 6, 9);

        Iterator<Integer> iter1 = data.iterator();
        System.out.println("Iterate using while hasNext:");
        while (iter1.hasNext()) {
            System.out.print(iter1.next());
        }

        Iterator<Integer> iter2 = data.iterator();
        System.out.println("\nIterate using for each:");
        for (Integer i : data) {
            System.out.print(iter2.next());
        }
    }

    private void testIsWff() {
        // --- Valid WFFs according to the updated rules ---
        LogicWord word1 = new LogicWord("p"); // Atomic (standalone)
        LogicWord word2 = new LogicWord("(p)"); // Parenthesized atomic (as an operand)
        LogicWord word3 = new LogicWord("~(p)"); // Negation of parenthesized atomic
        LogicWord word4 = new LogicWord("(p)∧(q)"); // Binary connective with parenthesized atomics
        LogicWord word5 = new LogicWord("(p)∨(q)");
        LogicWord word6 = new LogicWord("(p)⟹(q)");
        LogicWord word7 = new LogicWord("(p)⟺(q)");
        LogicWord word9 = new LogicWord("~((p)∧(q))"); // Negation of a complex WFF (which is itself enclosed in parentheses)
        LogicWord word10 = new LogicWord("((p)∧(q))⟹(P3)"); // Complex binary, where first operand is a binary WFF
        LogicWord word11 = new LogicWord("(p)∨((q)∧(P3))"); // Complex binary
        LogicWord word12 = new LogicWord("~(~(p))"); // Nested negation
        LogicWord word13 = new LogicWord("(p)∧(~(q)∨(P3))"); // Complex

        // --- Invalid WFFs (for testing error handling) ---
        LogicWord word17 = new LogicWord(""); // Empty string
        LogicWord word18 = new LogicWord("p∧q"); // Atomic operands not parenthesized
        LogicWord word19 = new LogicWord("(p∧)"); // Missing right operand, `p` not parenthesized
        LogicWord word20 = new LogicWord("∧(q)"); // Missing left operand
        LogicWord word21 = new LogicWord("pq"); // Multiple variables without operators
        LogicWord word22 = new LogicWord("~"); // Operator without operand
        LogicWord word23 = new LogicWord("(p~q)"); // Operator in wrong position, operands not parenthesized
        LogicWord word24 = new LogicWord("~(p"); // Unmatched opening parenthesis for negation operand
        LogicWord word25 = new LogicWord("p)"); // Unmatched closing parenthesis
        LogicWord word26 = new LogicWord("~p"); // Negation operand not parenthesized
        LogicWord word27 = new LogicWord("(p)∧∧(q)"); // Double operator
        LogicWord word28 = new LogicWord("(p)⟺"); // Missing right operand
        LogicWord word29 = new LogicWord("(p(q))"); // Invalid structure
        LogicWord word30 = new LogicWord("~("); // Incomplete expression
        LogicWord word32 = new LogicWord("p q"); // Contains spaces

        LogicWord[] testWords = {
                word1, word2, word3, word4, word5, word6, word7,
                word9, word10, word11, word12, word13,
                word17, word18, word19, word20,
                word21, word22, word23, word24, word25, word26, word27, word28, word29, word30,
                word32
        };

        System.out.println("--- Testing well_formed_formula.LogicWord.isWellFormed() ---\n" +
                "---------------------------------------");

        for (LogicWord currentWord : testWords) {
            System.out.println(currentWord);
        }
        System.out.println("---------------------------------------");
    }


    private <T> void printUnsorted (T[] data) {
        System.out.println("Unsorted data: " + Arrays.toString(data));
    }

    private <T extends Comparable<T>> void printUnsorted (LinkedList<T> data) {
        System.out.println("Unsorted data: " + data.toString());
    }
}
