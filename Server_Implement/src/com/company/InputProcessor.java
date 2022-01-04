package com.company;

import java.util.ArrayList;

import java.util.List;

public class InputProcessor {

    public static List<String> users = new ArrayList<>();

    public String processInput(String input) {

        String[] firstline = input.split(" ");

        if (firstline[0].equals("GET") && firstline[1].equals("/users")) {
            return users.toString();

        } else if (firstline[0].equals("POST") && firstline[1].equals("/user")) {
            int firstindex = input.indexOf("{") - 1;
            int lastindex = input.indexOf("}") + 1;

            String user = input.substring(firstindex, lastindex) + "\n";

            for (int i = 0; i < users.size(); i++) {
                String str = users.get(i);
                String email = str.substring(str.lastIndexOf("email\":"), str.indexOf("@")).trim();

                if (user.contains(email)) {
                    users.remove(i);
                }
            }
                users.add(user);
                return user;
            }
        return "Please write only GET or POST request";
    }
}
