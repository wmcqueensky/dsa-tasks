package test;

import org.example.Main;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testNormalString() {
        Assert.assertEquals("a2b1c5a3", Main.compress("aabcccccaaa"));
    }

    @Test
    public void testSingleCharacterString() {
        Assert.assertEquals("a", Main.compress("a"));
    }

    @Test
    public void testTwoDifferentCharacters() {
        Assert.assertEquals("ab", Main.compress("ab"));
    }

    @Test
    public void testAlreadyCompressedString() {
        Assert.assertEquals("a2b2c2", Main.compress("a2b2c2"));
    }

    @Test
    public void testEmptyString() {
        Assert.assertEquals("", Main.compress(""));
    }

    @Test
    public void testNoCompressionBenefit() {
        Assert.assertEquals("abcdef", Main.compress("abcdef"));
    }
}
