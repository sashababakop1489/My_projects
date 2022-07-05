package com.babakov.task.sumofthedigits;

import java.math.BigInteger;

public class SumOfTheDigits {
    int x = 100;
    BigInteger result = BigInteger.valueOf(1);
    int sum = 0;

    public void run() {
        for (int i = 1; i <= x; i++) {
            result = (result.multiply(BigInteger.valueOf(i)));
        }
        String strOfDigits = result.toString();
        String[] arrOfDigits = strOfDigits.split("");

        for (String s : arrOfDigits) {
            sum += Integer.parseInt(s);
        }
        System.out.println("sum = " + sum);
    }
}
