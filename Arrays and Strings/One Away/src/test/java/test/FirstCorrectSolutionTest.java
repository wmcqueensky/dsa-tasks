package test;

import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstCorrectSolutionTest {

    private Main main = new Main();

    @Test
    public void testSameStrings() {
        assertTrue(main.oneEditAway("example", "example"));
    }

    @Test
    public void testOneInsertion() {
        assertTrue(main.oneEditAway("example", "exmple"));
        assertTrue(main.oneEditAway("exmple", "example"));
    }

    @Test
    public void testOneDeletion() {
        assertTrue(main.oneEditAway("example", "examples"));
        assertTrue(main.oneEditAway("examples", "example"));
    }

    @Test
    public void testOneReplacement() {
        assertTrue(main.oneEditAway("example", "exampke"));
        assertTrue(main.oneEditAway("example", "exanple"));
    }

    @Test
    public void testMoreThanOneChange() {
        assertFalse(main.oneEditAway("example", "examles"));
        assertFalse(main.oneEditAway("example", "exampkes"));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(main.oneEditAway("", ""));
        assertTrue(main.oneEditAway("a", ""));
        assertTrue(main.oneEditAway("", "a"));
        assertFalse(main.oneEditAway("ab", ""));
        assertFalse(main.oneEditAway("", "ab"));
    }

    @Test
    public void testDifferentLengths() {
        assertFalse(main.oneEditAway("example", "exa"));
        assertFalse(main.oneEditAway("example", "examples123"));
    }

    @Test
    public void testOneInsertionAtStart() {
        assertTrue(main.oneEditAway("example", "eexample"));
    }

    @Test
    public void testOneInsertionAtEnd() {
        assertTrue(main.oneEditAway("example", "examplee"));
    }

    @Test
    public void testOneDeletionAtStart() {
        assertTrue(main.oneEditAway("example", "xample"));
    }

    @Test
    public void testOneDeletionAtEnd() {
        assertTrue(main.oneEditAway("example", "exampl"));
    }

    @Test
    public void testOneReplacementAtStart() {
        assertTrue(main.oneEditAway("example", "axample"));
    }

    @Test
    public void testOneReplacementAtEnd() {
        assertTrue(main.oneEditAway("example", "examplx"));
    }

    @Test
    public void testStringsOfDifferentLengthsAndMoreThanOneChange() {
        assertFalse(main.oneEditAway("example", "examp"));
        assertFalse(main.oneEditAway("example", "examplesx"));
    }
}
