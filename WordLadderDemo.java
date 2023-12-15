package Graphs;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadderDemo {

    class Pair {
        String word;
        int level;

        Pair(String s, int n) {
            this.word = s;
            this.level = n;
        }
    }
    public static void main(String[] args) {
        String[] words = {"hot", "dog", "dot", "lot", "lot", "cog"};
        System.out.println(new WordLadderDemo().wordLadderLength("hit", "cog", words));
        System.out.println(new WordLadderDemo().findSequences("hit", "cog", words));
    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        HashSet<String> set = new HashSet<>(Arrays.asList(wordList));
        set.remove(startWord);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        while(!q.isEmpty()) {
            String word = q.peek().word;
            int level = q.peek().level;

            if(word.equals(targetWord)) return level;

            q.poll();

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedChar = word.toCharArray();
                    replacedChar[i] = ch;
                    String replacedWord = new String(replacedChar);

                    if(set.contains(replacedWord)) {
                        q.add(new Pair(replacedWord, level+1));
                        set.remove(replacedWord);
                    }
                }
            }
        }

        return 0;
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        HashSet<String> set = new HashSet<>(Arrays.asList(wordList));

        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> l = new ArrayList<>();
        l.add(startWord);
        q.add(l);

        int level = 0;

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            ArrayList<String> vec = q.peek();
            q.poll();

            if (vec.size() > level) {
                // level has changed
                level++;

                for(String it : usedOnLevel) {
                    set.remove(it);
                }

                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            if(word.equals(targetWord)) {
                if(ans.size() == 0) {
                    ans.add(vec);
                }
                else if(ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedChar = word.toCharArray();
                    replacedChar[i] = ch;
                    String replacedWord = new String(replacedChar);

                    if(set.contains(replacedWord)) {
                        vec.add(replacedWord);

                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);

                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return ans;
    }
}
