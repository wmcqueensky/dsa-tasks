package test;

import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstCorrectSolutionMergedTest {

    private Main main = new Main();

    @Test
    public void testSameStrings() {
        assertTrue(main.oneEditAwayMerged("example", "example"));
    }

    @Test
    public void testOneInsertion() {
        assertTrue(main.oneEditAwayMerged("example", "exmple"));
        assertTrue(main.oneEditAwayMerged("exmple", "example"));
    }

    @Test
    public void testOneDeletion() {
        assertTrue(main.oneEditAwayMerged("example", "examples"));
        assertTrue(main.oneEditAwayMerged("examples", "example"));
    }

    @Test
    public void testOneReplacement() {
        assertTrue(main.oneEditAwayMerged("example", "exampke"));
        assertTrue(main.oneEditAwayMerged("example", "exanple"));
    }

    @Test
    public void testMoreThanOneChange() {
        assertFalse(main.oneEditAwayMerged("example", "exampl"));
        assertFalse(main.oneEditAwayMerged("example", "examles"));
        assertFalse(main.oneEditAwayMerged("example", "exampkes"));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(main.oneEditAwayMerged("", ""));
        assertTrue(main.oneEditAwayMerged("a", ""));
        assertTrue(main.oneEditAwayMerged("", "a"));
        assertFalse(main.oneEditAwayMerged("ab", ""));
        assertFalse(main.oneEditAwayMerged("", "ab"));
    }

    @Test
    public void testDifferentLengths() {
        assertFalse(main.oneEditAwayMerged("example", "exa"));
        assertFalse(main.oneEditAwayMerged("example", "examples123"));
    }

    @Test
    public void testOneInsertionAtStart() {
        assertTrue(main.oneEditAwayMerged("example", "eexample"));
    }

    @Test
    public void testOneInsertionAtEnd() {
        assertTrue(main.oneEditAwayMerged("example", "examplee"));
    }

    @Test
    public void testOneDeletionAtStart() {
        assertTrue(main.oneEditAwayMerged("example", "xample"));
    }

    @Test
    public void testOneDeletionAtEnd() {
        assertTrue(main.oneEditAwayMerged("example", "exampl"));
    }

    @Test
    public void testOneReplacementAtStart() {
        assertTrue(main.oneEditAwayMerged("example", "axample"));
    }

    @Test
    public void testOneReplacementAtEnd() {
        assertTrue(main.oneEditAwayMerged("example", "examplx"));
    }

    @Test
    public void testStringsOfDifferentLengthsAndMoreThanOneChange() {
        assertFalse(main.oneEditAwayMerged("example", "examp"));
        assertFalse(main.oneEditAwayMerged("example", "examplesx"));
    }
}

