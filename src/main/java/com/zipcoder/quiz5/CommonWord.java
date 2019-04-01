package com.zipcoder.quiz5;

import org.omg.CORBA.INTERNAL;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.*;

public class CommonWord {

    /**
     * Read the text and count each word in the text. Return the word and its
     * count in descending order to see what's the common word used in the text.
     * Store the word and its count in an Entry object.
     *
     * @param text
     * @return a list of word and its count in descending order stored in the object entry
     */

    List<String> entries;
    List<Entry> listRet = new ArrayList<>();


    public List<Entry> getCommonWord(String text) {
        entries = Arrays.asList(text.split(" "));

       // entries.stream().map(string -> string.toLowerCase());

      //  List<String> sorted = entries.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Map<String, Long> map = new TreeMap<>();
        map = entries.stream().collect(Collectors.groupingBy(x->x.toLowerCase(),Collectors.counting()));

        Map<String, Long> sortedMap = new TreeMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())
                ).forEachOrdered(x -> sortedMap.put(x.getKey(),x.getValue()));




        return null;
    }
}