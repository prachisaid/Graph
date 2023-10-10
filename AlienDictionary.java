package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = {
                "baa", "abcd", "abca", "cab", "cad"
        };

        System.out.println(new AlienDictionary().findOrder(dict, 5, 4));
    }

    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < K; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());

            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);

        String ans = "";

        for(int i : topo){
            ans = ans + (char)(i + (int)('a'));
        }

        return ans;
    }

    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> lst = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            lst.add(node);

            for(int adjNode : adj.get(node)){
                indegree[adjNode]--;

                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }

        return lst;
    }
}
