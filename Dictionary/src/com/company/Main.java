package com.company;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("dictionary.csv", false)) {


            File file = new File("C:\\Users\\Alex\\basecamp\\Spell_Checker\\words\\known.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String myWord;
            while ((myWord = reader.readLine()) != null) {

                if (myWord.equals("")) {
                    continue;
                }
                //System.out.println(myWord);

                URL url = JsonUtils.createUrl("https://api.dictionaryapi.dev/api/v2/entries/en/" + myWord);

                String resultJson = JsonUtils.parseUrl(url);
                if (resultJson == null) {
                    continue;
                }

                JsonUtils.parseCurrentJson(resultJson);
                if (JsonUtils.word == null || JsonUtils.word.equals("")) {
                    break;
                }

                writer.append("Word");
                writer.append(",");
                writer.append("Phonetic");
                writer.append(",");
                writer.append("Meanings");
                writer.append(",");
                writer.append("Examples");
                writer.append("\n");


                writer.append(JsonUtils.word);
                writer.append('\n');
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

