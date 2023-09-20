package com.company;

import java.util.Random;

public class Matrix {

    private int [][] matrix;
    final static int ROWS = 4;
    final static int COLS = 4;

    // 최초행렬 만드는 생성자
    public Matrix() {
        Random ran = new Random();
        matrix = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                matrix[i][j] = ran.nextInt(999)+1;
            }
        }
    }

    /* this.matrix = matrix;를 하면 matrix 객체의 matrix를
        transMat 객체의 matrix에 복사할 때 배열의 주소값을 복사하므로 (얕은 복사)
        selfTranspose 메소드를 실행했을 때 matrix 객체의 matrix도 변경됨. (같은 배열을 공유하므로)
        따라서 배열의 값 하나하나를 복사해주어야한다.
    */
    public Matrix (int [][] matrix) {
        this.matrix = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix clone() {
        return new Matrix(matrix);
    }

    public Matrix turnRight() {
        int [][] rightMatrix = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                rightMatrix[i][j] = matrix[ROWS-1-j][i];
            }
        }
        return new Matrix(rightMatrix);
    }

    public Matrix turnLeft() {
        int [][] leftMatrix = new int[ROWS][COLS];
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                leftMatrix[i][j] = matrix[j][ROWS-1-i];
            }
        }
        return new Matrix(leftMatrix);
    }

    // transMat 객체에 있는 matrix 배열의 값을 변경(전치).
    // 배열의 값을 직접 변경하는 것이므로 n이 4가 되었을 때 바뀐 행렬을 반환하는 것이 아님.
    // 그래서 return null을 해준다.
    public Matrix selfTranspose(int n) { // n = 행
        if(n>=COLS)
            return null;
        else {
            int tmp;
            for(int i=n; i<COLS; i++) {
                if(n!=i) {
                    tmp = matrix[n][i];
                    matrix[n][i] = matrix[i][n];
                    matrix[i][n] = tmp;
                }
            }
            return selfTranspose(n+1);
        }
    }

    // 각 행렬을 한 행씩 모두 출력하고 다음 행으로 넘어가기
    // 오른쪽 정렬하기
    public void printRow(int row) {
        System.out.print("| ");
        for(int e : matrix[row]) {
            if(e>=100)
                System.out.print(e + " ");
            else if(e>=10)
                System.out.printf("%3d ", e);
            else
                System.out.printf("%6d ", e);
        }
        System.out.print("| ");
    }
}