package Graphs;

import java.util.ArrayList;

public class DetectCycleDFS {
    public static void main(String[] args) {
        DetectCycleDFS dfs = new DetectCycleDFS();
        System.out.println(dfs.isCycle(7, adjList()));
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V+1];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(detectCycle(V, visited, adj, i, -1)) return true;
            }
        }

        return false;
    }

    private boolean detectCycle(int V, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int val, int parent){
        visited[val] = true;
        ArrayList<Integer> lst = adj.get(val);

        for(int i : lst){
            if(!visited[i]){
                if(detectCycle(i, visited, adj, i, val)) return true;
            }

            else if(parent != i){
                return true;
            }
        }

        return false;
    }

    private static ArrayList<ArrayList<Integer>> adjList(){
        int n = 7, m = 6;

        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++){
            lst.add(new ArrayList<Integer>());
        }

        lst.get(1).add(2);
        lst.get(2).add(1);

        lst.get(1).add(3);
        lst.get(3).add(1);

        lst.get(2).add(5);
        lst.get(5).add(2);

        lst.get(3).add(4);
        lst.get(4).add(3);

        lst.get(5).add(7);
        lst.get(7).add(5);

        lst.get(6).add(7);
        lst.get(7).add(6);

        lst.get(3).add(6);
        lst.get(6).add(3);

        return lst;
    }
}
