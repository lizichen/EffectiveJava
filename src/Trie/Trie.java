package Trie;

import java.util.LinkedList;

/**
 * Constraint:
 *      all lower case
 *      all alphabets
 */

public class Trie {

    protected static int UNIQUE_ELEMENTS = 26;
    private TrieNode root;
    private static int ascii_base = 97; // 'a' = 97
    private int number_of_words = 0;

    public Trie(){
        root = new TrieNode();
    }

    // return false when the word exists, otherwise, add into the trie and return true;
    public boolean add(String word){

        if(this.contains(word)){
            return false;
        }

        TrieNode cursor = root;
        char[] arr = word.toLowerCase().toCharArray();

        for(int i=0; i<arr.length; i++){
            int alphabetIndex = arr[i] - ascii_base;
            cursor.setHasValueFlagTrue(alphabetIndex);

            if(i == arr.length - 1){ // the last alphabet
                cursor.setEndingFlagTrue(alphabetIndex);
                break;
            }

            if(cursor.next == null){ // Create new List of TrieNode
                cursor.next = new TrieNode[Trie.UNIQUE_ELEMENTS];
                cursor.next[alphabetIndex] = new TrieNode();
                cursor = cursor.next[alphabetIndex];
            }else if(cursor.next[alphabetIndex] == null){ // Create new TrieNode
                cursor.next[alphabetIndex] = new TrieNode();
                cursor = cursor.next[alphabetIndex];
            }else{
                cursor = cursor.next[alphabetIndex];
            }
        }
        this.number_of_words++;
        return true;
    }

    public boolean contains(String word){
        char[] arr = word.toLowerCase().toCharArray();
        TrieNode cursor = root;
        for(int i=0; i<arr.length; i++){
            if(cursor == null)
                break;

            int alphabetIndex = arr[i] - ascii_base;

            if(i == arr.length - 1){ // check for last alphabet
                return cursor.checkEndingFlag(alphabetIndex);
            }

            if(!cursor.checkHasValueFlag(alphabetIndex)) {
                return false;
            }else if(cursor.next == null){
                return false;
            }else{
                cursor = cursor.next[alphabetIndex];
            }
        }
        return false;
    }

    // TODO: find corner cases maybe?
    // if the trie has word, remove it and return true,
    // if the word does not exist, return false;
    public boolean delete(String word){
        if(!contains(word)){
            return false;
        }

        // go through the endingFlag and remove the last alphabet
        // from true to false; meaning it cannot be a word ending.
        char[] arr = word.toLowerCase().toCharArray();
        TrieNode cursor = root;
        for(int i=0; i<arr.length; i++){
            int alphabetIndex = arr[i] - ascii_base;
            if (i == arr.length-1){ // last alphabet
                cursor.setEndingFlagFalse(alphabetIndex);

                if(--this.number_of_words == 0){
                    System.out.println("INFO: The Trie is empty now!");
                    this.root = new TrieNode(); // clean up memory space
                }
                return true;
            }else{
                cursor = cursor.next[alphabetIndex];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie testTrie = new Trie();

        String[] addStringList = {"she", "sheng", "english", "eng"};
        String[] searchStringList = {"she", "shen", "engl"};
        String[] removeStringList = {"sheng", "she", "english", "eng", "engl"};

        for(String s: addStringList){
            System.out.println("adding "+s);
            System.out.println(testTrie.add(s));
        }

        for (String s: searchStringList){
            System.out.println("searching "+s);
            System.out.println(testTrie.contains(s));
        }

        for(String s: removeStringList){
            System.out.println("removing "+s);
            System.out.println(testTrie.delete(s));
        }
    }
}
