package com.test.code;

import java.util.HashMap;
import java.util.Map;

public class ScratchPad {



    public  class A {
        public void printName(){
            System.out.println("Value-A");
        }
    }
    public class B extends A{
        public void printName(){
            System.out.println("Value-B");
        }
    }


    public class C extends A{
        public void printName(){
            System.out.println("Value-C");
        }
    }
}
