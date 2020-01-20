package com.test.code.misc;

public class B extends A {

    public void testB(){
        System.out.println("B");
    }


    public static void main(String[] args) {

        B b = new B();
        b.testB();

        b.testA();

        A a = b;
        a.testA();


        A aa = new B();
        aa.testA();


        b = (B) aa;
//
        b.testB();
        b.testA();
    }
}
