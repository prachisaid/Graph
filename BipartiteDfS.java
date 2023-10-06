package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteDfS {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(!check(i, 0, color, adj)) return false;
            }
        }

        return true;
    }

    private boolean check(int start, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[start] = col;

        for(int adjacentNode : adj.get(start)){
            int adjColor = 1 - color[start];

            if(color[adjacentNode] == -1) {
                if(!check(adjacentNode, adjColor, color, adj)) return false;
            }
            else if(color[adjacentNode] == color[start]) return false;
        }

        return true;
    }
}
