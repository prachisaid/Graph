package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class KosarajuAlgorithm {

    private void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        visited[node] = 1;

        for(Integer it : adj.get(node)) {
            if(visited[it] == 0) {
                dfs(it, visited, adj, stack);
            }
        }
        stack.add(node);
    }

    private void dfs3(int node, int[] visited, ArrayList<ArrayList<Integer>> adjT, List<Integer> ans) {
        ans.add(node);
        visited[node] = 1;

        for(Integer it : adjT.get(node)) {
            if(visited[it] == 0) dfs3(it, visited, adjT, ans);
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                dfs(i, visited, adj, stack);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for(int i = 0; i < adj.size(); i++) {
            visited[i] = 0;
            for(Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        int scc = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while(!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int node = stack.peek();
            stack.pop();

            if (visited[node] == 0) {
                scc++;
                dfs3(node, visited, adjT, temp);
            }

            ans.add(temp);
        }

        System.out.println(ans);
        return scc;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
        }

        KosarajuAlgorithm obj = new KosarajuAlgorithm();
        System.out.println(obj.kosaraju(5, adj));
    }
}
