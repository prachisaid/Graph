package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBFS {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        DetectCycleBFS dt = new DetectCycleBFS();

        System.out.println(dt.isCycle(7, adjList()));
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(checkCycle(i, V, adj, visited)) return true;
            }
        }

        return false;
    }

    private boolean checkCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Pair> q = new LinkedList<>();
        visited[src] = true;
        q.add(new Pair(src, -1));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(int adjacentNode : adj.get(node)){
                if(!visited[adjacentNode]){
                    visited[adjacentNode] = true;
                    q.add(new Pair(adjacentNode, node));
                }

                else if(parent != adjacentNode){
                    return true;
                }
            }
        }

        return false;
    }

    private static ArrayList<ArrayList<Integer>> adjList(){
        int n = 7, m = 6;

        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++){
            lst.add(new ArrayList<Integer>());
        }

        lst.get(1).add(2);
        lst.get(2).add(1);

        lst.get(1).add(3);
        lst.get(3).add(1);

        lst.get(2).add(5);
        lst.get(5).add(2);

        lst.get(3).add(4);
        lst.get(4).add(3);

        lst.get(5).add(4);
        lst.get(4).add(5);

        lst.get(5).add(7);
        lst.get(7).add(5);

//        lst.get(6).add(7);
//        lst.get(7).add(6);

        lst.get(3).add(6);
        lst.get(6).add(3);

        return lst;
    }
}
