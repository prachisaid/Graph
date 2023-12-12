package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DFSTraversal {
    public static void main(String[] args) {
        int m = 8, n = 8;
        System.out.println(dfsOfGraph(8, adjList(m, n)));
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
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

    private static ArrayList<ArrayList<Integer>> adjList(int m, int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges: ");
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
