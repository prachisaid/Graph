package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Tuple implements Comparable<Tuple>{
    int weight;
    int u;
    int v;

    Tuple(int u, int v, int w) {
        this.weight = w;
        this.u = u;
        this.v = v;
    }

    public int compareTo(Tuple compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
public class KrushkalsAlgorithm {
    public int spanningTree(int V, int E, int edges[][]) {
        List<Tuple> adj = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            int node = edges[i][0];
            int adjNode = edges[i][1];
            int wt = edges[i][2];

            Tuple t = new Tuple(node, adjNode, wt);
            adj.add(t);
        }

        DisjointSet ds = new DisjointSet(V);

        Collections.sort(adj);
        int min = 0;

        for(int i = 0; i < adj.size(); i++) {
            int u = adj.get(i).u;
            int v = adj.get(i).v;
            int wt = adj.get(i).weight;

            if(ds.findParent(u) != ds.findParent(v)) {
                min += wt;
                ds.unionByRank(u, v);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2},
                {0, 3, 6},
                {1, 4, 5},
                {3, 1, 8},
                {1, 2, 3},
                {4, 2, 7}
        };

        KrushkalsAlgorithm k = new KrushkalsAlgorithm();
        System.out.println(k.spanningTree(5, 6, arr));
    }
}
