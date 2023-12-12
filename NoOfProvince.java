package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvince {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(numProvinces(mat));
    }

    public static int numProvinces(int[][] mat) {
        int V = mat.length;
        ArrayList<ArrayList<Integer>> adj = adjList(mat, V);
        int[] visited = new int[V];
        int prov = 0;

        for(int i = 0; i < V; i++) {
            if(visited[i] != 1) {
                dfs(i, adj, visited);
                prov++;
            }
        }

        return prov;
    }

    private static void dfs(int val, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        if(visited[val] == 1) return;

        visited[val] = 1;
        ArrayList<Integer> adjList = adj.get(val);

        for(int lst : adjList) {
            if(visited[lst] != 1){
                dfs(lst, adj, visited);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> adjList(int[][] mat, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        return adj;
    }
}
