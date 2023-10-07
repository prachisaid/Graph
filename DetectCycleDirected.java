package Graphs;

import java.util.ArrayList;

public class DetectCycleDirected {
    public static void main(String[] args) {

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVis = new int[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(dfs(i, V, adj, visited, pathVis)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int node, int V, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVis) {
        visited[node] = 1;
        pathVis[node] = 1;

        for(int adjacentNode : adj.get(node)){
            if(visited[adjacentNode] == 0){
                if(dfs(adjacentNode, V, adj, visited, pathVis)) return true;
            }
            else if(pathVis[adjacentNode] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
}
