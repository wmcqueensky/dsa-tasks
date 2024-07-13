package test;

import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstAttemptTest {

    private Main main = new Main();

    @Test
    public void testSameStrings() {
        assertTrue(main.isOneChangeAway("example", "example"));
    }

    @Test
    public void testOneInsertion() {
        assertTrue(main.isOneChangeAway("example", "exmple"));
        assertTrue(main.isOneChangeAway("exmple", "example"));
    }

    @Test
    public void testOneDeletion() {
        assertTrue(main.isOneChangeAway("example", "examples"));
        assertTrue(main.isOneChangeAway("examples", "example"));
    }

    @Test
    public void testOneReplacement() {
        assertTrue(main.isOneChangeAway("example", "exampke"));
        assertTrue(main.isOneChangeAway("example", "exanple"));
    }

    @Test
    public void testMoreThanOneChange() {
        assertFalse(main.isOneChangeAway("example", "exampl"));
        assertFalse(main.isOneChangeAway("example", "examles"));
        assertFalse(main.isOneChangeAway("example", "exampkes"));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(main.isOneChangeAway("", ""));
        assertTrue(main.isOneChangeAway("a", ""));
        assertTrue(main.isOneChangeAway("", "a"));
        assertFalse(main.isOneChangeAway("ab", ""));
        assertFalse(main.isOneChangeAway("", "ab"));
    }

    @Test
    public void testDifferentLengths() {
        assertFalse(main.isOneChangeAway("example", "exa"));
        assertFalse(main.isOneChangeAway("example", "examples123"));
    }
}
