package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] != -1){
                if(check(i, color, adj)) return true;
            }
        }

        return false;
    }

    private boolean check(int start, int[] color, ArrayList<ArrayList<Integer>>adj){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int adjacentNode : adj.get(node)){
                if(color[adjacentNode] == -1){
                    color[adjacentNode] = 1 - color[node];
                }

                else if(color[adjacentNode] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
