package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedBFS {
    public static void main(String[] args) {

    }

    static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int topo = 0;
        int i = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            topo++;

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(topo == V) return false;
        return true;
    }
}
