package com.zipcoder.quiz5;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MissingCharacterTest {
    private MissingCharacter missingCharacter = new MissingCharacter();

    @Test
    public void testIsPangram_whenItIsTheWholeAlphabet() {
        String text = "abcdefghijklmnopqrstuvwxyz";
        int expectedSize = 0;

        List<Character> missingChars = missingCharacter.getMissingChars(text);

        Assert.assertEquals(expectedSize, missingChars.size());
    }

    @Test
    public void testIsPangram_whenMissingAFewCharacters() {
        String text = "bcdefghijkmnopqrstvwxy";
        int expectedSize = 4;

        List<Character> missingChars = missingCharacter.getMissingChars(text);

        Assert.assertEquals(expectedSize, missingChars.size());
        Assert.assertTrue(missingChars.contains('a'));
        Assert.assertTrue(missingChars.contains('l'));
        Assert.assertTrue(missingChars.contains('u'));
        Assert.assertTrue(missingChars.contains('z'));
    }

    @Test
    public void testIsPangram_whenSentenceHasRepeatedCharacters() {
        String text = "The quick brown fox jumps over the lazy dog";
        int expectedSize = 0;

        List<Character> missingChars = missingCharacter.getMissingChars(text);

        Assert.assertEquals(expectedSize, missingChars.size());
    }


    @Test
    public void testIsPangram_whenSentenceHasRepeatedAndMissingCharacters() {
        String text = "The quick brown fox jumps over the cat";
        int expectedSize = 5;

        List<Character> missingChars = missingCharacter.getMissingChars(text);

        Assert.assertEquals(expectedSize, missingChars.size());

        Assert.assertTrue(missingChars.contains('l'));
        Assert.assertTrue(missingChars.contains('z'));
        Assert.assertTrue(missingChars.contains('y'));
        Assert.assertTrue(missingChars.contains('d'));
        Assert.assertTrue(missingChars.contains('g'));
    }

}
