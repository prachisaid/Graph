package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MakingALargeIsland {

    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n) {
            for(int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if(parent.get(node) == node) {
                return node;
            }

            int val = findParent(parent.get(node));
            parent.set(parent.get(node), val);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            if(ulp_u == ulp_v) return;

            if(size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
            else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    private boolean isValid(int nrow, int ncol, int n) {
        return (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n);
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};


        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) continue;

                for(int i = 0; i < 4; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];

                    if(isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        int max = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) continue;

                HashSet<Integer> set = new HashSet<>();
                for(int i = 0; i < 4; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];

                    if(isValid(nrow, ncol, n)) {
                        if(grid[nrow][ncol] == 1) {
                            set.add(ds.findParent(nrow * n + ncol));
                        }
                    }
                }

                int sizeTotal = 0;
                for(Integer parents : set) {
                    sizeTotal += ds.size.get(parents);
                }

                max = Math.max(max, sizeTotal + 1);
            }
        }

        for(int cellNo = 0; cellNo < (n * n); cellNo++) {
            max = Math.max(max, ds.size.get(ds.findParent(cellNo)));
        }

        return max;
    }

    public static void main(String[] args) {
        MakingALargeIsland obj = new MakingALargeIsland();

        int[][] arr = {
                {1, 0},
                {0, 1}
        };
        System.out.println(obj.largestIsland(arr));
    }
}
