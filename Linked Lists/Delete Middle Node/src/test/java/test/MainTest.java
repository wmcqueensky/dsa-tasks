package test;

import org.example.Main;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMiddleNodeWithOddSize() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Main.middleNode(list);

        // Expected: middle node (3) removed
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        assertEquals(expected, list);
    }

    @Test
    public void testMiddleNodeWithEvenSize() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Main.middleNode(list);

        // Expected: middle node (element at index 2) removed
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        assertEquals(expected, list);
    }

    @Test
    public void testMiddleNodeWithLessThanThreeElements() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);

        Main.middleNode(list);

        // Expected: no changes to the list
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);

        assertEquals(expected, list);
    }

    @Test
    public void testMiddleNodeWithEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        Main.middleNode(list);

        // Expected: no changes to the list
        assertTrue(list.isEmpty());
    }

    @Test
    public void testMiddleNodeWithSingleElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        Main.middleNode(list);

        // Expected: no changes to the list
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);

        assertEquals(expected, list);
    }
}
