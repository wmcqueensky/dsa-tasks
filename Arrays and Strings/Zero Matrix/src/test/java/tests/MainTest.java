package tests;

import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MainTest {

    private final Main main = new Main();

    @Test
    public void testZeroMatrixWithZero() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {1, 0, 3},
                {0, 0, 0},
                {7, 0, 9}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroMatrixWithoutZero() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeros_singleZero() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {1, 0, 3},
                {0, 0, 0},
                {7, 0, 9}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeros_multipleZeros() {
        int[][] matrix = {
                {0, 2, 3},
                {4, 0, 6},
                {7, 8, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeros_noZeros() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeros_allZeros() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeros_singleRowZero() {
        int[][] matrix = {
                {1, 2, 3},
                {0, 0, 0},
                {7, 8, 9}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testSetZeros_singleColumnZero() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {1, 0, 3},
                {0, 0, 0},
                {7, 0, 9}
        };

        main.setZeros(matrix);
        assertArrayEquals(expected, matrix);
    }

    //test setZerosBetter



    @Test
    public void testSetZerosBetter_multipleZeros() {
        int[][] matrix = {
                {0, 2, 3},
                {4, 0, 6},
                {7, 8, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        main.setZerosBetter(matrix);
        assertArrayEquals(expected, matrix);
    }

}
