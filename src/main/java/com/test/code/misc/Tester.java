package com.test.code.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Tester {

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        //test(scanner);


        String s = "abcaba";
        Map<Character, Integer> frequencies = s.chars().boxed()
                .collect(toMap(
                        // key = char
                        k -> Character.valueOf((char) k.intValue()),
                        v -> 1,         // 1 occurence
                        Integer::sum)); // counting


        List<Integer> integerList = new ArrayList<>();
        int sum = integerList.stream().filter(i -> i > 10).mapToInt(i -> i).sum();

        Stream<String> names = Stream.of("aBc", "d", "ef");
        List<String> collect = names.map(a -> a.toUpperCase()).collect(Collectors.toList());

        collect.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect);

        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
//flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList
                .flatMap(strList -> strList.stream());

        flatStream.forEach(System.out::println);

        Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream contains 4? " + numbers3.anyMatch(i -> i == 4));
//Stream contains 4? true

        Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream contains all elements less than 10? " + numbers4.allMatch(i -> i < 10));
//Stream contains all elements less than 10? true

        Stream<Integer> numbers5 = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream doesn't contain 10? " + numbers5.noneMatch(i -> i == 10));
//Stream doesn't contain 10? true

        Stream<String> names4 = Stream.of("Pankaj", "Amit", "David", "Lisa");
        Optional<String> firstNameWithD = names4.filter(i -> i.startsWith("D")).findFirst();
        if (firstNameWithD.isPresent()) {
            System.out.println("First Name starting with D=" + firstNameWithD.get()); //David
        }


    }

    private static void test(Scanner infile) throws IOException {

        int lines = 0;
        int chars = 0;
        int words = 0;
        double wordLength = 0;

        DecimalFormat df2 = new DecimalFormat("#.##");


        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(
                    "/Users/pratikbajaj/Desktop/myfile.txt"));
            String line = bufferedReader.readLine();
            while (line != null) {
                lines++;
                final String[] wordsArray = line.split("\\s+");
                words += wordsArray.length;
                for (String wordsinArray : wordsArray) {
                    chars += wordsinArray.trim().length();
                }
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


//        while(infile.hasNextLine()){
//            lines++;
//            final String line = infile.nextLine();
//            final String[] wordsArray = line.split("\\s+");
//            words += wordsArray.length;
//            for(String wordsinArray : wordsArray){
//                chars += wordsinArray.trim().length();
//            }
//        }


        if (lines > 100) {
            wordLength = (double) chars / words;
        }

        BigDecimal bd = new BigDecimal(wordLength).setScale(2, RoundingMode.HALF_UP);

        System.out.println(" Lines = " + lines);
        System.out.println(" words = " + words);
        System.out.println(" cahards = " + chars);

        if (lines > 100) {
            System.out.println(" wordLength = " + bd.doubleValue());
        }


    }
}
