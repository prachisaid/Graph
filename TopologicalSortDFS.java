package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {

    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(i, V, adj, visited, stack);
            }
        }

        int[] ans = new int[V];
        int i = 0;

        while(!stack.isEmpty()){
            ans[i] = stack.pop();
            i++;
        }

        return ans;
    }

    private static void dfs(int node, int V, ArrayList<ArrayList<Integer>> adj, int[] visited,Stack<Integer> stack){
        visited[node] = 1;

        for(int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                dfs(adjNode, V, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
