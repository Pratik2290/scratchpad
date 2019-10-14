package com.test.code;

public class Challenge1 {

    public static Integer decode(String roman) {


        int sum = 0;

        for (int i = 0; i < roman.length(); i++) {

            Character charAt = roman.charAt(i);
            RomanType romanType = RomanType.valueOf(String.valueOf(charAt));
            if (romanType != null) {
                int myValue = romanType.intValue;
                int nextIndex = i + 1;
                if (nextIndex < roman.length()) {
                    Character nextChar = roman.charAt(nextIndex);
                    RomanType nextCharRType = RomanType.valueOf(String.valueOf(nextChar));
                    if (nextCharRType.ordinal() > romanType.ordinal()) {
                        myValue = -myValue;
                    }
                }
                sum = sum + myValue;
            }
        }
        return sum;


    }

    private enum RomanType {


        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private Integer intValue;

        RomanType(Integer intValue) {
            this.intValue = intValue;
        }
    }
}
