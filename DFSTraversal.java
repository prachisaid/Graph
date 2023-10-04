package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DFSTraversal {
    public static void main(String[] args) {
        System.out.println(dfsOfGraph(8, adjList()));
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans= new ArrayList<>();
        int[] visited = new int[V+1];
        dfs(1, visited, ans, adj);

        return ans;
    }

    private static void dfs(int val, int[] visited, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        if(visited[val] == 1) return;

        visited[val] = 1;
        ans.add(val);
        ArrayList<Integer> lst = adj.get(val);

        for(int i : lst){
            if(visited[i] != 1){
                dfs(i, visited, ans, adj);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> adjList(){
        int n = 8, m = 6;

        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++){
            lst.add(new ArrayList<Integer>());
        }

        lst.get(1).add(2);
        lst.get(2).add(1);

        lst.get(1).add(6);
        lst.get(6).add(1);

        lst.get(2).add(3);
        lst.get(3).add(2);

        lst.get(2).add(4);
        lst.get(4).add(2);

        lst.get(5).add(4);
        lst.get(4).add(5);

        lst.get(5).add(7);
        lst.get(7).add(5);

        lst.get(6).add(7);
        lst.get(7).add(6);

        lst.get(6).add(8);
        lst.get(8).add(7);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < lst.get(i).size(); j++){
                System.out.print(lst.get(i).get(j) + " ");
            }

            System.out.println();
        }

        return lst;
    }
}
