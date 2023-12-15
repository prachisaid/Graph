package Graphs;

public class NumberOfOperationToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int extraEdges = 0;
        DisjointSet ds = new DisjointSet(n);

        for (int[] connection : connections) {
            if (ds.findParent(connection[0]) == ds.findParent(connection[1])) {
                extraEdges += 1;
            } else {
                ds.unionByRank(connection[0], connection[1]);
            }
        }

        int component = 0;
        for(int i = 0; i < n; i++) {
            if(ds.findParent(i) == i) {
                component += 1;
            }
        }

        if(extraEdges >= (component - 1)) return (component - 1);
        else return -1;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2}
        };

        NumberOfOperationToMakeNetworkConnected op = new NumberOfOperationToMakeNetworkConnected();
        System.out.println(op.makeConnected(6, arr));
    }
}
