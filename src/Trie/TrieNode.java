package Trie;


import java.util.List;

public class TrieNode {

    // an array of boolean, length = UNIQUE_ELEMENTS
    // meaning of endingFlag value:
    //      true: is a ending
    //      false: is not a ending
    private boolean[] endingFlag = new boolean[Trie.UNIQUE_ELEMENTS]; // init: all false
    // meaning of hasValueFlag value:
    //      true: has alphabet
    //      false: has no alphabet
    private boolean[] hasValueFlag = new boolean[Trie.UNIQUE_ELEMENTS]; // init:  all false

    protected TrieNode[] next; // do not initilize before actually need it.

    public void setHasValueFlagTrue(int index){
        this.hasValueFlag[index] = true;
    }

    public void setHasValueFlagFalse(int index){
        this.hasValueFlag[index] = false;
    }

    public boolean checkHasValueFlag(int index){
        return this.hasValueFlag[index];
    }

    public void setEndingFlagTrue(int index){
        this.endingFlag[index] = true;
    }

    public void setEndingFlagFalse(int index){
        this.endingFlag[index] = false;
    }

    public boolean checkEndingFlag(int index){
        return this.endingFlag[index];
    }
}
