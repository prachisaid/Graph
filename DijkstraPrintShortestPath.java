package Graphs;

import java.util.*;

public class DijkstraPrintShortestPath {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 2},
                {1, 4, 1},
                {2, 5, 5},
                {4, 3, 3},
                {2, 3, 4},
                {3, 5, 1}
        };

        System.out.println(shortestPath(5, 6, arr));
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int[] dist = new int[n+1];
        int[] parent = new int[n+1];

        for(int i = 1; i <= n; i++){
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.first));
        pq.add(new Pair(0, 1));
        dist[1] = 0;

        while(pq.size() != 0){
            int node = pq.peek().second;
            int wt = pq.peek().first;
            pq.remove();

            for(Pair pr : adj.get(node)){
                int adjNode = pr.first;
                int edgeWeight = pr.second;

                if(dist[adjNode] > wt + edgeWeight){
                    dist[adjNode] = wt + edgeWeight;
                    parent[adjNode] = node;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        int node = n;

        while(parent[node] != node){
            ans.add(node);
            node = parent[node];
        }

        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}
