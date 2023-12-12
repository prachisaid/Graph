package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathDAG {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        System.out.println(Arrays.toString(new ShortestPathDAG().shortestPath(6, 7, edges)));
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for(int i = 0; i < N; i++){
            ArrayList<Pair> lst = new ArrayList<>();
            adj.add(lst);
        }

        for(int i = 0; i < M; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] visited = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            if(visited[i] == 0) {
                topo(i, adj, visited, stack);
            }
        }

        int[] dist = new int[N];

        Arrays.fill(dist, (int) (1e9));

        dist[0] = 0;

        while(!stack.isEmpty()){
            int val = stack.peek();
            stack.pop();

            for(int i = 0; i < adj.get(val).size(); i++){
                int v = adj.get(val).get(i).first;
                int wt = adj.get(val).get(i).second;
                int totalWt = wt + dist[val];

                if(dist[v] > totalWt) dist[v] = totalWt;
            }
        }

        return dist;

    }

    private void topo(int node, ArrayList<ArrayList<Pair>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;

//        for(int i = 0; i < adj.get(node).size(); i++){
//            int v = adj.get(node).get(i).first;
//
//            if(visited[v] == 0) topo(v, adj, visited, stack);
//        }

        for(Pair p : adj.get(node)) {
            int v = p.first;

            if(visited[v] == 0) {
                topo(v, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
