package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearchTree {

   private  static final   Set<String> knowWords = new HashSet<>();
    private static final Set<String> unKnowWords = new HashSet<>();


   private static final ArrayList<String> vocabulary = new ArrayList<>();

   public static List<String> knowWordsList = new ArrayList<>();
    public static List<String> unKnowWordsList = new ArrayList<>();

    /* Class containing left
           and right child of current node
         * and key value*/
    static class Node {
        String key;
        Node left, right;

        public Node(String item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    static Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }


     static Node arrayToBTS ( int start, int end){

            if (start > end) {
                return null;
            }
            int mid = (start + end)/2;
            Node node = new Node(vocabulary.get(mid));


            node.left = arrayToBTS(start,mid-1);

            node.right = arrayToBTS(mid+1, end);

            return node;
        }
    static void search(Node root, String key)throws Exception {
        //try {

            if (key.compareTo(root.key) == 0) {
                knowWords.add(key);
            } else if (root.left == null && root.right == null && key.compareTo(root.key) != 0) {
                unKnowWords.add(key);
            }
            // Base Cases: root is null or key is present at root
            // Key is greater than root's key
            else if (key.compareTo(root.key) < 0) {
                if (root.left != null){
                    search(root.left, key);
                }

            } else if (key.compareTo(root.key) > 0) {
                if (root.right != null){
                    search(root.right, key);
                }
            }
    }

    public static void bst() throws Exception {
        long startTimeVoc = System.currentTimeMillis();
        File dictionaries = new File("C:\\Users\\Alex\\basecamp\\tasks\\3-algorithms\\dictionaries\\large");

        BufferedReader voca = new BufferedReader(new FileReader(dictionaries));


        BinarySearchTree tree = new BinarySearchTree();

        vocabulary.ensureCapacity(140000);

        String str;

        while ((str = voca.readLine()) != null) {
            vocabulary.add(str);
        }
        voca.close();

       root = tree.arrayToBTS(0,  vocabulary.size()-1);

        long endTimeVoc = System.currentTimeMillis();
        long dictionary_loading_time = endTimeVoc - startTimeVoc;

        //****************************************************************************

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

                    search(root, words[i]);

                }
            }
        }
        long endTimeText = System.currentTimeMillis();
        long texts_processing_time = endTimeText - startTimeText;

        System.out.println("binary_search_tree: <dictionary_loading_time " +  dictionary_loading_time + " ms> "+
                "<texts_processing_time " + texts_processing_time + " ms> "+
                "<number_of_invalid_words "  +countInvalid + "> "+
                "<number_of_checked_words " + number_of_checked_words + ">");

        knowWordsList = new ArrayList<>(knowWords);
        unKnowWordsList = new ArrayList<>(unKnowWords);
    }

}

