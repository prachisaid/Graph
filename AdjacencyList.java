package Graphs;

import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {
        int m = 6, n = 5;
        new AdjacencyList().adjList(m, n);
    }

    private void adjList(int m, int n){
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

        print(adj);
    }

    private void print(ArrayList<ArrayList<Integer>> adj) {
        for(ArrayList<Integer> a : adj) {
            System.out.println(a);
        }
    }
}
