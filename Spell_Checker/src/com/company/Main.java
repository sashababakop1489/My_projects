package com.company;

import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws Exception {

        BinarySearchTree.bst();
        Trie.trie();
        WorkWithHashMap.hashMap();

        Set<String> allKnowWordsSet = new HashSet<>();
        Set<String> allUnKnowWordsSet = new HashSet<>();

        allKnowWordsSet.addAll(WorkWithHashMap.knowWordsList);
        allKnowWordsSet.addAll(BinarySearchTree.knowWordsList);
        allKnowWordsSet.addAll(Trie.knowWordsList);

        allUnKnowWordsSet.addAll(WorkWithHashMap.unKnowWordsList);
        allUnKnowWordsSet.addAll(BinarySearchTree.unKnowWordsList);
        allUnKnowWordsSet.addAll(Trie.unKnowWordsList);

        List<String> allKnowWordsList = new ArrayList<>(allKnowWordsSet);
        List<String> allUnKnowWordsList = new ArrayList<>(allUnKnowWordsSet);

        Collections.sort(allKnowWordsList);
        Collections.sort(allUnKnowWordsList);

        //Write words in file
        try (FileWriter writer = new FileWriter("words\\known.txt", false)) {
            // запись по словам
            for (String w : allKnowWordsList) {
                writer.append('\n');
                writer.append(w);
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (FileWriter writer = new FileWriter("words\\unknown.txt", false)) {
            // запись по словам
            for (String w : allUnKnowWordsList) {
                writer.append('\n');
                writer.append(w);
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}


