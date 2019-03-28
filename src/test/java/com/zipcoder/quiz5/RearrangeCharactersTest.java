package com.zipcoder.quiz5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RearrangeCharactersTest {
    private RearrangeCharacters rearrangeCharacters = new RearrangeCharacters();

    @Test
    public void testGetList_forOneLetter(){
        String input = "a";
        String[] expectedWords = {"a"};

        List<String> actualWords = rearrangeCharacters.getWords(input);

        Assert.assertArrayEquals(expectedWords, toArray(actualWords));
    }

    @Test
    public void testGetList_forTwo(){
        String input = "ab";
        String[] expectedWords = {"ab", "ba"};

        List<String> actualWords = rearrangeCharacters.getWords(input);

        Assert.assertArrayEquals(expectedWords, toArray(actualWords));
    }

    @Test
    public void testGetList_forThree(){
        String input = "abc";
        String[] expectedWords = {"abc", "acb", "bac", "bca", "cab", "cba"};

        List<String> actualWords = rearrangeCharacters.getWords(input);

        Assert.assertArrayEquals(expectedWords, toArray(actualWords));
    }


    @Test
    public void testGetList_forMultipleCharacters(){
        String input = "dogs";
        String[] expectedWords = {  "dogs", "sgod", "gsod", "ogsd",
                                    "dosg", "sgdo", "gsdo", "ogds",
                                    "dsgo", "sdgo", "gdso", "osdg",
                                    "dsog", "sdog", "gdos", "osgd",
                                    "dgso", "sodg", "gods", "odgs",
                                    "dgos", "sogd", "gosd", "odsg"};

        List<String> actualWords = rearrangeCharacters.getWords(input);
        Arrays.sort(expectedWords);
        Assert.assertArrayEquals(expectedWords, toArray(actualWords));
    }

    private String[] toArray(List<String> actualWords) {
        String[] words = new String[actualWords.size()];
        Arrays.sort(actualWords.toArray(words));
        return words;
    }



}
