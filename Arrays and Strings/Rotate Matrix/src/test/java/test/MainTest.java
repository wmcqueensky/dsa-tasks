package test;
import org.example.*;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MainTest {

    @Test
    public void testRotateMatrix3x3() {
        Main main = new Main();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        assertArrayEquals(expected, main.rotateMatrix(matrix));
    }

    @Test
    public void testRotateMatrix4x4() {
        Main main = new Main();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] expected = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };

        assertArrayEquals(expected, main.rotateMatrix(matrix));
    }

    @Test
    public void testRotateMatrix1x1() {
        Main main = new Main();
        int[][] matrix = {
                {1}
        };

        int[][] expected = {
                {1}
        };

        assertArrayEquals(expected, main.rotateMatrix(matrix));
    }

    @Test
    public void testRotateMatrixEmpty() {
        Main main = new Main();
        int[][] matrix = {};

        int[][] expected = {};

        assertArrayEquals(expected, main.rotateMatrix(matrix));
    }
}
