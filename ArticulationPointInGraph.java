package Graphs;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointInGraph {

    public int timer = 1;
    private void dfs(int node, int parent, int[] visited, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;

        for(int it : adj.get(node)) {
            if(it == parent) continue;

            if(visited[it] == 0) {
                dfs(it, node, visited, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }

                child++;
            }

            else{
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        if(child > 1 && parent == -1) mark[node] = 1;
    }

    public ArrayList<Integer> articulationPoint(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                dfs(i, -1, visited, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(mark[i] == 1) {
                ans.add(i);
            }
        }

        if(ans.size() == 0) ans.add(-1);
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            connections.add(new ArrayList<>());
        }

        connections.get(0).add(1);
        connections.get(1).add(0);

        connections.get(0).add(2);
        connections.get(2).add(0);

        connections.get(0).add(3);
        connections.get(3).add(0);

        connections.get(2).add(3);
        connections.get(3).add(2);

        connections.get(2).add(4);
        connections.get(4).add(2);

        connections.get(2).add(5);
        connections.get(5).add(2);

        connections.get(4).add(6);
        connections.get(6).add(4);

        connections.get(6).add(5);
        connections.get(5).add(6);

        ArticulationPointInGraph obj = new ArticulationPointInGraph();
        System.out.println(obj.articulationPoint(7, connections));
    }
}
