package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {
    public static void main(String[] args) {

    }

        class Pair{
            int first;
            int second;

            Pair(int f, int s){
                this.first = f;
                this.second = s;
            }
        }

        class Tuple{
            int first;
            int second;
            int third;

            Tuple(int f, int s, int t){
                this.first = f;
                this.second = s;
                this.third = t;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<>());
            }

            int m = flights.length;
            for(int i = 0; i < m; i++){
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }

            Queue<Tuple> q = new LinkedList<>();
            //{stop, {node, dist}}
            q.add(new Tuple(0, src, 0));

            int[] dist = new int[n];
            for(int i = 0; i < n; i++){
                dist[i] = (int)(1e9);
            }

            dist[src] = 0;

            while(!q.isEmpty()){
                Tuple tp = q.peek();
                q.remove();

                int stops = tp.first;
                int node = tp.second;
                int cost = tp.third;

                if(stops > k) continue;

                for(Pair itr : adj.get(node)){
                    int adjNode = itr.first;
                    int edW = itr.second;

                    if(cost + edW < dist[adjNode] && stops <= k){
                        dist[adjNode] = cost + edW;
                        q.add(new Tuple(stops + 1, adjNode, cost + edW));
                    }
                }
            }

            if(dist[dst] == (int)(1e9)) return -1;
            return dist[dst];
        }
}
