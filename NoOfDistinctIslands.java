package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        System.out.println(new NoOfDistinctIslands().countDistinctIslands(grid));
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, visited, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }

        return st.size();
    }

    public String toString(int r, int c){
        String ans = Integer.toString(r) + " " + Integer.toString(c);
        return ans;
    }
    private void dfs(int row, int col, int[][] visited, int[][] grid, ArrayList<String> vec, int baseRow, int baseCol) {
        visited[row][col] = 1;
        vec.add(toString(row - baseRow, col - baseCol));

        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow, ncol, visited, grid, vec, baseRow, baseCol);
            }
        }
    }
}
