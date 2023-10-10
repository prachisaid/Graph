package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderI {

    class Pair{
        String word;
        int level;

        Pair(String w, int l){
            this.word = w;
            this.level = l;
        }
    }
    public static void main(String[] args) {
        String[] lst = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new WordLadderI().wordLadderLength("hit", "cog", lst));
    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));

        HashSet<String> set = new HashSet<>(Arrays.asList(wordList));
        set.remove(startWord);

        while(!q.isEmpty()){
            String word = q.peek().word;
            int level = q.peek().level;
            q.remove();

            if(word.equals(targetWord)) return level;

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, level+1));
                    }
                }
            }
        }

        return 0;
    }
}
