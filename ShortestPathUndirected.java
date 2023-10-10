package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirected {
    public static void main(String[] args) {

    }

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int wt = q.peek().second;

            q.remove();

            int totalWt = wt + 1;

            for(int adjNode : adj.get(node)){
                if(totalWt > dist[adjNode]){
                    dist[adjNode] = totalWt;
                    q.add(new Pair(adjNode, totalWt));
                }
            }
        }

        return dist;
    }
}
