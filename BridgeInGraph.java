package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeInGraph {
    public int timer = 1;

    private void dfs(int node, int parent, int[] visited, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low,
                     List<List<Integer>> bridges) {

        visited[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        for(Integer it : adj.get(node)) {
            if(it == parent) continue;

            if(visited[it] == 0) {
                dfs(it, node, visited, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                if(low[node] < low[it]) {
                    bridges.add(Arrays.asList(it, node));
                }
            }
            else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(List<Integer> it : connections) {
            int u = it.get(0);
            int v = it.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] visited = new int[n];
        
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, visited, adj, tin, low, ans);
        return ans;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            connections.add(new ArrayList<>());
        }

        connections.get(0).add(0);
        connections.get(0).add(1);
        connections.get(1).add(1);
        connections.get(1).add(2);
        connections.get(2).add(2);
        connections.get(2).add(0);
        connections.get(3).add(1);
        connections.get(3).add(3);

        BridgeInGraph obj = new BridgeInGraph();
        System.out.println(obj.criticalConnections(4, connections));
    }
}
