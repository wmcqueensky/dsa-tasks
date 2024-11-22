package org.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Arrays;
public class MainTest {
    @Test
    void testDeleteDupsWithBuiltinStructure() {
        // Arrange
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 5));
        LinkedList<Integer> expectedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Act
        deleteDupsWithBuiltinStructure(inputList);

        // Assert
        assertEquals(expectedList, inputList, "The duplicates should be removed, preserving the order of unique elements.");
    }

    void deleteDupsWithBuiltinStructure(LinkedList<Integer> list) {
        HashSet<Integer> set = new HashSet<Integer>();
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (set.contains(current)) {
                iterator.remove();
            } else {
                set.add(current);
            }
        }
    }
}
