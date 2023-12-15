package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgorithm {

    class Tuple {
        int weight;
        int node;
        int parent;

        Tuple(int w, int n, int p) {
           this.weight = w;
           this.node = n;
           this.parent = p;
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 4, 5},
                {3, 1, 8},
                {1, 2, 3},
                {4, 2, 7}
        };

        System.out.println(new PrimsAlgorithm().spanningTree(5, 6, arr));
    }

    public int spanningTree(int V, int E, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] i : edges) {
            adj.get(i[0]).add(new Pair(i[1], i[2]));
            adj.get(i[1]).add(new Pair(i[0], i[2]));
        }

        int[] visited = new int[V];
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.weight - y.weight);
        int sum = 0;

        pq.add(new Tuple(0, 0, -1));

        while(!pq.isEmpty()) {
            int weight = pq.peek().weight;
            int node = pq.peek().node;
            int parent = pq.peek().parent;
            pq.poll();

            if(parent == -1) {
                visited[node] = 1;
            }
            else {
                if(visited[node] == 0) {
                    visited[node] = 1;
                    sum += weight;
                }
            }

            for(Pair p : adj.get(node)) {
                int n = p.first;
                int wt = p.second;

                if(visited[n] == 0) {
                    pq.add(new Tuple(wt, n, node));
                }
            }
        }

        return sum;
    }
}
