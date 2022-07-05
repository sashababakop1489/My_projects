package com.babakov.task.brackets;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Brackets {

    int counterOpen = 0;
    int counterClose = 0;
    String ans = "";

    public void generationBrackets() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a simple positive number");
        int N = 0;
        try {
            N = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            generationBrackets();
        }
        gen(N, counterOpen, counterClose, ans);
    }

    private static void gen(int n, int counterOpen, int counterClose, String ans) {
        if (counterOpen + counterClose == 2 * n)
            System.out.println(ans);
        if (counterOpen < n)
            gen(n, counterOpen + 1, counterClose, ans + '(');
        if (counterOpen > counterClose)
            gen(n, counterOpen, counterClose + 1, ans + ')');
    }
}
