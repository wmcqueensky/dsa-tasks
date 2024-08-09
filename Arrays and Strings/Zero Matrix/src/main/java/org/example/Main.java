package org.example;

public class Main {

    //My correct solution Time Complexity O(NxMx(N+M)) Space Complexity(NxM)
    public int[][] zeroMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] zeroedMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                zeroedMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        zeroedMatrix[k][j] = 0;
                    }

                    for (int p = 0; p < m; p++) {
                        zeroedMatrix[i][p] = 0;
                    }
                }
            }
        }

        return zeroedMatrix;
    }

    //Better solution from the book O(N) space complexity
    public void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        //Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        //Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        //Nullify columns
        for (int j = 0; j < column.length; j++) {
            if (column[j]) nullifyColumn(matrix, j);
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }


    //Book solution with O(1) space
    public void setZerosBetter(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // Check if first column has zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        // Check for zeros in the rest of the array
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //Nullify rows based on values in first column
        for (int i = 0; i < matrix.length; i++) {
            nullifyRow(matrix, i);
        }

        //Nullify columns
        for (int j = 0; j < matrix[0].length; j++) {
            nullifyColumn(matrix, j);
        }

        //Nullify first row
        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        //Nullify first column
        if (colHasZero) {
            nullifyColumn(matrix, 0);
        }
    }
}