package com.test.code.misc;

public interface Mammal {
    default String identifyMyself(){
        System.out.println(" I am Mammal");
        return "";
    }
}
