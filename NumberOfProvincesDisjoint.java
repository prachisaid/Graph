package Graphs;

public class NumberOfProvincesDisjoint {
    public int findCircleNum(int[][] mat) {
        int v = mat.length;

        DisjointSet ds = new DisjointSet(v);

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(i != j && mat[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < mat.length; i++) {
            if(ds.findParent(i) == i) {
                ans++;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0},
        };
        System.out.println(new NumberOfProvincesDisjoint().findCircleNum(mat));
    }
}
