package com.company;

import java.io.*;
import java.util.*;

public class WorkWithHashMap {

    private static final Set<String> knowWords = new HashSet<>();
    private static final Set<String> unKnowWords = new HashSet<>();

    public static List<String> knowWordsList = new ArrayList<>();
    public static List<String> unKnowWordsList = new ArrayList<>();

    public static void hashMap() throws Exception{


        // write my vocabulary
        long startTimeVoc = System.currentTimeMillis();
        File dictionaries = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\dictionaries\\large");

        BufferedReader voca = new BufferedReader(new FileReader(dictionaries));

        HashMap<String, String> vocabulary = new HashMap<>();

        String str;

        while ((str = voca.readLine()) != null) {
            vocabulary.put(str, null);
        }
        voca.close();
        long endTimeVoc = System.currentTimeMillis();
        long dictionary_loading_time = endTimeVoc - startTimeVoc;

        //************************************************************************


        // read file and check
        File file1 = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\texts\\alice.txt");
        File file2 = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\texts\\dracula.txt");
        File file3 = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\texts\\sherlock.txt");

        BufferedReader[] readers = new BufferedReader[3];
        readers[0] = new BufferedReader(new FileReader(file1));
        readers[1] = new BufferedReader(new FileReader(file2));
        readers[2] = new BufferedReader(new FileReader(file3));

        int number_of_checked_words = 0;
        int countInvalid = 0;  // Word is considered invalid
        long startTimeText = System.currentTimeMillis();
        for (BufferedReader reader : readers) {
            String st;
            while ((st = reader.readLine()) != null) {
                //String[] words = st.toLowerCase().split("[\\s//^_,.(!?*;):\"]+");
                //String[] words = st.toLowerCase().split("[\\W&&[^']]");
                String[] words = st.toLowerCase().split("[^a-zA-Z'[0-9]]");
                for (int i = 0; i < words.length; i++) {

                    if (words[i].equals("") || words[i].equals("'") || words[i].equals("-")) {
                        continue;
                    }

                    if (words[i].length() > 45 || words[i].startsWith("'") || words[i].startsWith("-")){
                        countInvalid++;
                        continue;
                    }

                    if (words[i].endsWith("'")) {
                        words[i] = words[i].substring(0, words[i].length() - 1);
                    }

                    number_of_checked_words++;

                    if (vocabulary.containsKey(words[i])) {
                        knowWords.add(words[i]);

                    } else {
                        unKnowWords.add(words[i]);

                    }
                }
            }
        }
        long endTimeText = System.currentTimeMillis();
        long texts_processing_time = endTimeText - startTimeText;

        System.out.println("hash_map: <dictionary_loading_time " +  dictionary_loading_time + " ms> "+
                        "<texts_processing_time " + texts_processing_time + " ms> "+
                        "<number_of_invalid_words "  +countInvalid + "> "+
                        "<number_of_checked_words " + number_of_checked_words + ">");

        knowWordsList = new ArrayList<>(knowWords);
        unKnowWordsList = new ArrayList<>(unKnowWords);
    }
}
