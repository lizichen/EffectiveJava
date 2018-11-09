package Graph;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) // corner case
            return 0;

        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int distance = 1;

        while (!q.isEmpty()) { // start BFS-like search
            int size = q.size();
            for (int j = 0; j < size; j++) { // go through the current queue
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return distance;
                }else{
                    helper(cur, q, set); // put all valid word from set to q
                }
            }
            distance++;
        }
        return 0;
    }

    // remove valid word(s) from set, and put it(them) into the q.
    private void helper(String cur, Queue<String> q, Set<String> set){
        List<String> buffer = new ArrayList();
        for(String s : set){
            if(valid(cur, s)){
                q.offer(s);
                buffer.add(s);
            }
        }
        for(String s : buffer){
            set.remove(s);
        }
    }

    // a word t is valid if it has only 1 different char from s
    private boolean valid(String s, String t){
        int diff = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }

    /**
     *
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();

        int distance = 1;

        HashSet<String> visited = new HashSet();

        beginSet.add(endWord);
        endSet.add(beginWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            printSet(beginSet, endSet);

            //swap sets
            Set<String> set = beginSet;
            beginSet = endSet;
            endSet = set;

            Set<String> temp = new HashSet();
            for (String word : beginSet) {

                List<String> validWords = getValidWords(word, wordList);

                if(endSet.contains(word)){
                    System.out.println("Found! endSet has "+word);
                    return distance;
                }

                for(String validCandidates : validWords){
                    temp.add(validCandidates);
                }
            }
            beginSet = temp;
            distance++;
            System.out.println("distance = "+distance);
        }

        System.out.println("Does not found!");
        return 0;
    }

    private List<String> getValidWords(String word, List<String> wordList) {
        List<String> result = new ArrayList();
        for(String cand : wordList){
            if(valid(word, cand)){
                result.add(cand);
            }
        }
        return result;
    }

    public void printSet(Set<String> beginSet, Set<String> endSet){
        StringBuffer sb = new StringBuffer();
        for(String s : beginSet)
            sb.append(s+" ");
        System.out.println("beginSet: "+sb.toString());

        sb = new StringBuffer();
        for(String s : endSet)
            sb.append(s+" ");
        System.out.println("endSet: "+sb.toString());
    }

    public static void main(String[] args) {
        WordLadder_127 w = new WordLadder_127();
        String s1 = "hit";
        String s2 = "abc";
        List<String> sarr = new ArrayList();
        String[] ss = {"hot","dot","dog","lot","log","cog","abc","abo","aoo","ooo","doo"};
        for(String s : ss)
            sarr.add(s);
        System.out.println("result distance = "+w.ladderLength2(s1, s2, sarr));
    }
}
