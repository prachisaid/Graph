package Graphs;

import java.util.*;

public class Dijkstra {
    class Pair{
        int distance;
        int node;
        Pair(int d, int n){
            this.distance = d;
            this.node = n;
        }
    }
    public static void main(String[] args) {

    }

    int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        TreeMap<Integer, Integer> set = new TreeMap<>();
        int[] dist = new int[V];

        Arrays.fill(dist, (int)1e9);
        set.put(0, S);
        dist[S] = 0;

        while(!set.isEmpty()){
            int node = set.firstEntry().getValue();
            int distance = set.firstEntry().getKey();

            for(int i = 0; i < adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if(dist[adjNode] > distance + edgeWeight){
                    if(dist[adjNode] != 1e9) set.remove(dist[adjNode]);

                    dist[adjNode] = distance + edgeWeight;
                    set.put(dist[adjNode], adjNode);
                }
            }
        }

        return dist;
    }
}
