package matrix_new;

import java.util.Random;

public class Matrix {
    private final int BOUND = 999;
    private int[] matrix[];
    private int rowSize;
    private int colSize;

    // 정방행렬
    public Matrix(int size) {
        this(size, size);
    }

    public Matrix(int rowSize, int colSize) {
        Random rand = new Random();

        this.rowSize = rowSize;
        this. colSize = colSize;
        matrix = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                matrix[i][j] = rand.nextInt(BOUND) + 1;
            }
        }
    }

    private Matrix(int[] matrix[]) {
        this.matrix = matrix;
        this.rowSize = matrix.length;
        this.colSize = matrix[0].length;
    }

    public Matrix turnRightMatrix() {

        int[] newMatrix[] = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                newMatrix[j][rowSize-i-1] = matrix[i][j];
            }
        }
        return new Matrix(newMatrix);
    }

    public void printMatrix() {
        for (int[] arr : matrix) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
