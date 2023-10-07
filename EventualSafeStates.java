package Graphs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(new EventualSafeStates().eventualSafeNodes(graph));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = graph.length;

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            int size = graph[i].length;
            for(int j = 0; j < size; j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] check = new int[V];
        int[] visited = new int[V];
        int[] pathVis = new int[V];

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, V, adj, visited, pathVis, check);
            }
        }

        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(check[i] == 1) {
                lst.add(i);
            }
        }

        return lst;
    }

    private boolean dfs(int node, int V, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVis, int[] check) {
        visited[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int adjacentNode : adj.get(node)){
            if(visited[adjacentNode] == 0){
                if(dfs(adjacentNode, V, adj, visited, pathVis, check)) return true;
            }
            else if(pathVis[adjacentNode] == 1){
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}
