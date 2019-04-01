package com.zipcoder.quiz5;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testGenerateRandom(){
        Stream.generate(Math::random)
                .limit(10)
                .forEach(x -> System.out.println(x));
    }


    @Test
    public void testGenerateValue(){
        Stream.generate(() -> "Echo")
                .limit(50)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testIterate(){
        Stream.iterate(1, x -> x + 2)
                .limit(10)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testSubStream(){
        int[] array = {1, 4, 6, 9};
        Arrays.stream(array, 1, 4)
                .forEach(x -> System.out.println(x));

    }

    @Test
    public void testEmpty(){
        Stream.empty()
                .limit(10)
                .forEach(x -> System.out.println(x));

    }

    @Test
    public void testConcat(){
        Stream<String> stream1 = Arrays.stream(new String[]{"a", "b"});
        Stream<String> stream2 = Arrays.stream(new String[]{"c"});

        Stream.concat(stream1, stream2)
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testFilter(){
        String[] wordArray = {"pear", "apple", "orange", "grape"};
        Stream<String> words = Arrays.stream(wordArray);

        String[] fruits = words.filter(x -> x.length() > 4)
                .sorted()
                .toArray(size -> new String[size]);

        System.out.println(fruits.toString());
    }

    @Test
    public void testMap(){
        Stream<String> words = Stream.of("pear", "apple", "orange", "grape");

        List<Integer> sizes = words.map(x -> x.length())
                .collect(Collectors.toList());

        System.out.println(sizes);
    }

    @Test
    public void testFlatMap(){
        Stream<String> words = Stream.of("pear", "apple", "orange", "grape");

//        Stream<Stream<String>> map = words.map(x -> Stream.of(x.split("")));
//        List<Stream<String>> listMap = map.collect(Collectors.toList());
//        for(Stream<String> value : listMap) {
//            List<String> chars = value.collect(Collectors.toList());
//            for(String c : chars) {
//                System.out.println(c);
//            }
//        }


        Stream<String> flatMap = words.flatMap(x -> Stream.of(x.split("")));
        List<String> chars = flatMap.collect(Collectors.toList());
        for(String c : chars) {
            System.out.println(c);
        }
    }

    @Test
    public void testDistinct(){
        List<Integer> ints = Stream.of(1, 4, 4, 7, 1)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(ints);
    }

    @Test
    public void testSorted(){
        Stream<String> words = Stream.of("pear", "apple", "orange", "grage");

        List<String> sortedByWord = words.sorted().collect(Collectors.toList());

        System.out.println(sortedByWord);

//        List<String> sortedByLength = words.sorted((x, y) -> x.length() - y.length())
//                                        .collect(Collectors.toList());
//
//        System.out.println(sortedByLength);
    }


    @Test
    public void testCount(){
        Stream<String> words = Stream.of("pear", "apple", "orange", "grage");

       long count = words.sorted().count();
     //   List<String> sorted = words.sorted().collect(Collectors.toList());
        System.out.println(count);
      //  System.out.println(sorted);
    }

    @Test
    public void testMin(){
        Optional<Integer> min = Stream.of(1, 4, 4, 7, 1).min(Integer::compareTo);
        System.out.println(min.get());
    }

    public int compare(Integer x, Integer y){
        return x - y;
    }

    @Test
    public void testNoValue(){
        Stream<Integer> empty = Stream.empty();
        Optional<Integer> min = empty.min((x, y) -> x.compareTo(y));
//        if (min.isPresent()) {
//            System.out.println(min.get());
//        }
        System.out.println(min.orElse(0));


    }

    @Test
    public void testFindFirst(){
        Stream<String> words = Stream.of("pear", "apple", "orange", "grage");

        Optional<String> first = words.findFirst();

        System.out.println(first.get());
    }

    @Test
    public void testFindAny(){
        Stream<String> words = Stream.of("pear", "apple", "orange", "grage");

        Optional<String> any = words.findAny();

        System.out.println(any.get());
    }


    @Test
    public void testReduce(){

        Optional<Integer> sum = Stream.of(1, 2, 6).reduce((x, y) -> x + y);
        System.out.println(sum.get());

        Integer sum2 = Stream.of(1, 2, 6).reduce(10, (x, y) -> x + y);
        System.out.println(sum2);

        Optional<Integer> max = Stream.of(1, 2, 6, 3, 5).reduce((x, y) -> x > y ? x : y);
        System.out.println(max.get());


        Stream<String> strings = Stream.of("one", "two", "three");
        Optional<String> newString = strings.reduce((x, y) -> x.concat(y));
        System.out.println(newString.get());

//        Stream<String> string2s = Stream.of("one", "two", "three", "four", "five");
//        Optional<String> newString = strings.reduce((x, y) -> x.length() > y.length() ? x : y);
//        System.out.println(newString.get());

    }

    @Test
    public void testToMap(){
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("Kris", 10));
        staffs.add(new Staff("Dolio", 11));
        staffs.add(new Staff("Froilan", 12));
        staffs.add(new Staff("Nhu", 13));

        Map<Long, Staff> map = staffs.stream()
                .collect(Collectors.toMap(Staff::getId, Function.identity()));

        for(Map.Entry<Long, Staff> value : map.entrySet()) {
            System.out.println(value.getKey() + " : " + value.getValue().getName());
        }
    }

    @Test
    public void testGroupBy(){
        List<Staff> staffs = new ArrayList<>();
//        staffs.add(new Staff("Kris", 10, "user"));
//        staffs.add(new Staff("Dolio", 11, "superuser"));
//        staffs.add(new Staff("Froilan", 12, "user"));
//        staffs.add(new Staff("Nhu", 13, "superuser"));

        Map<String, List<Staff>> map = staffs.stream()
                .collect(Collectors.groupingBy(Staff::getRole));

        for(Map.Entry<String, List<Staff>> value : map.entrySet()) {
            System.out.println(value.getKey() + " : ");
            for(Staff staff : value.getValue()) {
                System.out.println("\t" + staff.getName());
            }
        }
    }

    @Test
    public void testGroupByCount(){
        List<Staff> staffs = new ArrayList<>();
//        staffs.add(new Staff("Kris", 10, "user"));
//        staffs.add(new Staff("Dolio", 11, "superuser"));
//        staffs.add(new Staff("Froilan", 12, "user"));
//        staffs.add(new Staff("Nhu", 13, "superuser"));

        Function<Integer, Integer> function = Math::abs;
        Map<String, Long> map = staffs.stream()
                .collect(Collectors.groupingBy(Staff::getRole, Collectors.counting()));

        for(Map.Entry<String, Long> value : map.entrySet()) {
            System.out.println(value.getKey() + " : " + value.getValue());
        }
    }


    @Test
    public void testPartition(){
        Stream<String> words = Stream.of("The", "Quick", "Brown", "Fox");

        Map<Boolean, List<String>> partitioned = words.collect(Collectors.partitioningBy(x -> x.length() > 4));

        for(Map.Entry<Boolean, List<String>> value : partitioned.entrySet()) {
            System.out.println(value.getKey() + " : ");
            for(String string : value.getValue()) {
                System.out.println("\t" + string);
            }
        }

    }



    @Test
    public void testList(){
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("Kris", 10));
        staffs.add(new Staff("Dolio", 11));
        staffs.add(new Staff("Froilan", 12));
        staffs.add(new Staff("Nhu", 13));

//        List<Long> stringLength = staffs.stream()
//                .map(Staff::getId)
//                .sorted()
//                .collect(Collectors.toList());

//        System.out.println(stringLength);
    }

    private int getLength(String s) {
        return s.length();
    }

    public String getName(Staff staff){
        return staff.getName();
    }


}
