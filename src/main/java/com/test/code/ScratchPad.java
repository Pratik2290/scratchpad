package com.test.code;

import com.google.common.collect.Maps;

import java.util.Map;

public class ScratchPad {


    public class A {
        public void printName() {
            System.out.println("Value-A");
        }
    }

    public class B extends A {
        public void printName() {
            System.out.println("Value-B");
        }
    }


    public class C extends A {
        public void printName() {
            System.out.println("Value-C");
        }
    }

    public static void main(String[] args) {
        String s = "Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a blender. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that still must be done. There is a coolness, a calmness, when the sun does set.";
        //System.out.println(s.length());

        Map<String, Integer> map = Maps.newHashMap();
        map.put("a", 0);
        map.put("e", 0);
        map.put("i", 0);
        map.put("o", 0);
        map.put("u", 0);

        String[] split = s.split("\\s+");
        for (int i = 0; i < split.length; i++) {
            String word = split[i];
            char[] array = word.toCharArray();
            for (int j = 0; j < array.length; j++) {
                String ss = String.valueOf(array[j]);
                if (map.containsKey(ss)) {
                    Integer count = map.get(ss);
                    count++;
                    map.put(ss, count);
                }
            }
        }
        System.out.println(map);
    }


}
