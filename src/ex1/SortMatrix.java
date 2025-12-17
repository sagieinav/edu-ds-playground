package ex1;

public class SortMatrix {
    public void sortMatrixDiagonal(int[][] matrix)
    {
        int j, key;
        for (int i = 1; i < matrix.length; i++) {
            key = matrix[i][i];
            j = i - 1;
            while (j >= 0 && key < matrix[j][j]) {
                matrix[j + 1][j + 1] = matrix[j][j];
                j--;
            }
            matrix[j + 1][j + 1] = key;
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) { // For compatibility with mxn matrixes
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
