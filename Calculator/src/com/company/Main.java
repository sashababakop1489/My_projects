package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static BigInteger calc(List<String> postfix) {
        Deque<BigInteger> stack = new ArrayDeque<>();
        for (String x : postfix) {

            if (x.equals("^")) {
                BigInteger b = stack.pop(), a = stack.pop();
                BigInteger c = a;
                for (int i = 0; i <  b.intValue()-1; i++) {
                    a = a.multiply(c);
                }
                stack.push(a);
            } else if (x.equals("+")) {
                BigInteger b = stack.pop(), a = stack.pop();
                stack.push(a.add(b));
            }
            else if (x.equals("-")) {
                BigInteger b = stack.pop(), a = stack.pop();
                stack.push(a.subtract(b));
            } else if (x.equals("*")){
                BigInteger b = stack.pop(), a = stack.pop();
                stack.push(a.multiply(b));
            }
            else if (x.equals("/")) {
                BigInteger b = stack.pop(), a = stack.pop();
                stack.push(a.divide(b));
            }

            else stack.push(BigInteger.valueOf(Integer.parseInt(x)));
        }
        return stack.pop();
    }

    public static BigDecimal calcDouble(List<String> postfix) {
        Deque<BigDecimal> stack = new ArrayDeque<>();
        for (String x : postfix) {

            if (x.equals("^")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                BigDecimal c = a;
                for (int i = 0; i < b.intValue(); i++) {
                    a = a.multiply(c);
                }
                stack.push(a);
            }
            else if (x.equals("+")){
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(a.add(b));
            }
            else if (x.equals("-")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(a.subtract(b));
            }
            else if (x.equals("*")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(a.multiply(b));
            }
            else if (x.equals("/")) {
                BigDecimal b = stack.pop(), a = stack.pop();
                stack.push(a.divide(b));
            }
           else stack.push(BigDecimal.valueOf(Double.parseDouble(x)));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        //BigInteger integer = new BigInteger();
        System.out.println("Enter a mathematical expression");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        ExpressionParser n = new ExpressionParser();
        List<String> expression = n.parse(s);
        boolean flag = n.flag;
        if (flag) {
            for (String x : expression) System.out.print(x + " ");
            System.out.println();
            try {
                if (ExpressionParser.a)
                    System.out.println(calc(expression));
                else System.out.println(calcDouble(expression));
            }catch (NumberFormatException e){
                System.out.println("A very large number ");
            }catch (ArithmeticException arithmeticException){
                System.out.println("You cannot divide by zero ");
            }catch (NoSuchElementException noSuchElementException){
                System.out.println("You need write a mathematical expression");
            }
        }

        }
    }
