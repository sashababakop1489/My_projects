package com.babakov.task;

import com.babakov.task.brackets.Brackets;
import com.babakov.task.cities.FindEasiestRoute;
import com.babakov.task.sumofthedigits.SumOfTheDigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String menu;

            System.out.println("Press 1 for task with brackets.");
            System.out.println("Press 2 for task with cities.");
            System.out.println("Press 3 for task with sum of the digits.");
            System.out.println("Press 4 for go in menu");

            menu = reader.readLine();

            switch (menu) {
                case "1" -> new Brackets().generationBrackets();
                case "2" -> new FindEasiestRoute().run();
                case "3" -> new SumOfTheDigits().run();
            }
            if (menu.equals("4")) break;
        }
    }
}