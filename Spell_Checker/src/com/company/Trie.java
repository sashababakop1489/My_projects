package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Trie {

    private static final Set<String> knowWords = new HashSet<>();
    private static final Set<String> unKnowWords = new HashSet<>();

    public static List<String> knowWordsList = new ArrayList<>();
    public static List<String> unKnowWordsList = new ArrayList<>();


    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key)
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (index == -58){
                index = 0;
            }
            if (pCrawl.children[index] == null)// || pCrawl.children[index]< 0)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (index == -58){
                index = 0;
            }
            if (index < 0){
                break;
            }
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }

    public static void trie()throws Exception{

        long startTimeVoc = System.currentTimeMillis();

        File dictionaries = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\dictionaries\\large");

        BufferedReader voca = new BufferedReader(new FileReader(dictionaries));


         root = new TrieNode();

        String str;

        while ((str = voca.readLine()) != null) {
            insert(str);
        }
        voca.close();

        long endTimeVoc = System.currentTimeMillis();
        long dictionary_loading_time = endTimeVoc - startTimeVoc;

        //***********************************************************************************

        long startTimeText = System.currentTimeMillis();

        File file1 = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\texts\\alice.txt");
        File file2 = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\texts\\dracula.txt");
        File file3 = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\texts\\sherlock.txt");

        BufferedReader[] readers = new BufferedReader[3];
        readers[0] = new BufferedReader(new FileReader(file1));
        readers[1] = new BufferedReader(new FileReader(file2));
        readers[2] = new BufferedReader(new FileReader(file3));

        int number_of_checked_words = 0;
        int countInvalid = 0;  // Word is considered invalid

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

                    if (words[i].length() > 45 || words[i].startsWith("'") || words[i].startsWith("-")) {
                        countInvalid++;
                        continue;
                    }

                    if (words[i].endsWith("'")) {
                        words[i] = words[i].substring(0, words[i].length() - 1);
                    }

                    number_of_checked_words++;

                    if(search(words[i]))
                        knowWords.add(words[i]);
                    else unKnowWords.add(words[i]);

                }
            }
        }

        long endTimeText = System.currentTimeMillis();
        long texts_processing_time = endTimeText - startTimeText;

        System.out.println("trie: <dictionary_loading_time " +  dictionary_loading_time + " ms> "+
                "<texts_processing_time " + texts_processing_time + " ms> "+
                "<number_of_invalid_words "  +countInvalid + "> "+
                "<number_of_checked_words " + number_of_checked_words + ">");

        knowWordsList = new ArrayList<>(knowWords);
        unKnowWordsList = new ArrayList<>(unKnowWords);
    }
}
