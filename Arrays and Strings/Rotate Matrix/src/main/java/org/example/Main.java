package org.example;

public class Main {

    //My correct solution. Time complexity O(N^2)
    public int[][] rotateMatrix(int[][] matrix) {
        int N = matrix.length;
        int[][] rotatedMatrix = new int[N][N];
        for ( int i=0; i <= N-1; i++) {
            for (int j = 0; j <= N-1; j++) {
                rotatedMatrix[j][N - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }

    //Solution from book
    boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int N = matrix.length;

        for (int layer = 0; layer < N; layer++) {
            int first = layer;
            int last = N - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                //left->top
                matrix[first][i] = matrix[last-offset][first];

                //bottom->left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;
            }
        }
        return true;
    }

}