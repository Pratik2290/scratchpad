package com.test.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Challenge {
    private static String firstNonRepeatingLetter(String str) {

        Map<String, List<Integer>> characterIntegerMap = new LinkedHashMap<String, List<Integer>>();

        for (int i = 0; i < str.length(); i++) {
            String charValue = String.valueOf(str.charAt(i));
            System.out.println(" Char " + charValue);

            List<Integer> integers = characterIntegerMap.get(charValue.toLowerCase());
            if (integers == null) {
                integers = new ArrayList<>();
            }
            integers.add(i);
            characterIntegerMap.put(charValue.toLowerCase(), integers);
        }

        for (String character : characterIntegerMap.keySet()) {
            List<Integer> integers = characterIntegerMap.get(character);
            if (integers != null && integers.size() == 1) {
                Integer index = integers.get(0);
                return String.valueOf(str.charAt(index));
            }
        }
        return "";

    }


    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter("streSS"));
    }
}