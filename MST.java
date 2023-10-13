package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MST {
    class Tuple{
        int wt;
        int node;
        int parent;

        Tuple(int a, int b, int c){
            this.wt = a;
            this.node = b;
            this.parent = c;
        }
    }
    public static void main(String[] args) {
        int[][] edge  = {
                {0, 1, 5},
                {1, 2, 3},
                {0, 2, 1}
        };

        System.out.println(new MST().spanningTree(3, 3, edge));
    }

    int spanningTree(int V, int E, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.wt - y.wt);
        pq.add(new Tuple(0, 0, -1));

        int[] visited = new int[V];
        Arrays.fill(visited, 0);

        int sum  = 0;

        while(!pq.isEmpty()){
            int wt = pq.peek().wt;
            int node = pq.peek().node;
            int parent = pq.peek().parent;
            pq.remove();

            if(visited[node] == 0){
                visited[node] = 1;
                sum += wt;

                for(Pair it : adj.get(node)){
                    int adjNode = it.first;
                    int edW = it.second;

                    if(visited[adjNode] == 0) {
                        pq.add(new Tuple(edW, adjNode, node));
                    }
                }
            }
        }

        return sum;
    }
}
