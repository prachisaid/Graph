package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class WaysToArriveDest {
    public static void main(String[] args) {

    }

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] dist = new int[n];
        int[] ways = new int[n];

        pq.add(new Pair(0, 0));
        Arrays.fill(dist, (int)(1e9));
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()){
            int node = pq.peek().second;
            int dis = pq.peek().first;
            pq.remove();

            for(Pair pair : adj.get(node)){
                int adjNode = pair.second;
                int edW = pair.first;

                if(dis + edW < dist[adjNode]){
                    dist[adjNode] = dis + edW;
                    ways[adjNode] += ways[node];
                    pq.add(new Pair(dis+edW, adjNode));
                }
            }
        }

        return ways[n-1];
    }
}
