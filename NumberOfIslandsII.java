package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    private boolean valid(int adjRow, int adjCol, int n, int m) {
        return adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        int len = operators.length;

        for(int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];

            if(vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};

            for(int j = 0; j < 4; j++) {
                int adjRow = row + delRow[j];
                int adjCol = col + delCol[j];

                if(valid(adjRow, adjCol, n, m)){
                    if (vis[adjRow][adjCol] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjRow * m + col;
                        if (ds.findParent(nodeNo) != ds.findParent(adjNodeNo)) {
                            cnt--;
                            ds.unionByRank(nodeNo, adjNodeNo);
                        }
                    }
                }
            }

            ans.add(cnt);
        }

        return ans;

    }
    public static void main(String[] args) {
        NumberOfIslandsII obj = new NumberOfIslandsII();
        int[][] operators = {{0,0},{1,1},{2,2},{3,3}};
        System.out.println(obj.numOfIslands(4, 5, operators));
    }
}
