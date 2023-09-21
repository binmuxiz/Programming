package matrix_new;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Matrix matrix = new Matrix(n, m);
        matrix.printMatrix();

        Matrix turnRightMatrix = matrix.turnRightMatrix();
        turnRightMatrix.printMatrix();

    }
}
