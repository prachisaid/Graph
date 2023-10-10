package Graphs;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String[] lst = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new WordLadderII().findSequences("hit", "cog", lst));
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList){
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Queue<ArrayList<String>> q = new LinkedList<>();

        ArrayList<String> l = new ArrayList<>();
        l.add(startWord);
        q.add(l);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        int level = 0;

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            ArrayList<String> vec = q.peek();
            q.remove();

            if(vec.size() > level){
                level++;

                // remove nodes from the set if the level is changed
                for(String it : usedOnLevel){
                    set.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size() - 1);

            if(word.equals(targetWord)){
                if(ans.size() == 0){
                    ans.add(vec);
                }
                else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);

                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }

        return ans;
    }
}
