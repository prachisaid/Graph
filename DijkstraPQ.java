package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraPQ {
    class Pair{
        int distance;
        int node;

        Pair(int d, int n) {
            this.distance = d;
            this.node = n;
        }
    }
    public static void main(String[] args) {
        DijkstraPQ dj = new DijkstraPQ();
        System.out.println(Arrays.toString(dj.dijkstra(6, dj.adjList(8, 5), 0)));
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];

        pq.add(new Pair(0, S));
        dist[S] = 0;

        while(!pq.isEmpty()) {
            int distance = pq.peek().distance;
            int node = pq.peek().node;

            pq.poll();

            for(int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                int newDist = edgeWeight + distance;

                if(dist[adjNode] > newDist) {
                    pq.add(new Pair(newDist, adjNode));
                    dist[adjNode] = newDist;
                }
            }
        }

        return dist;
    }

    private ArrayList<ArrayList<ArrayList<Integer>>> adjList(int m, int n){
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
            for(int j = 0; j <= m; j++) {
                adj.get(i).add(new ArrayList<Integer>());
            }
        }

        System.out.println("Enter edges: ");
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).get(v).add(w);
            adj.get(v).get(u).add(w);
        }

        return adj;
    }
}
