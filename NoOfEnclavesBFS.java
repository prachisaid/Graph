package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclavesBFS {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };

        System.out.println(new NoOfEnclavesBFS().numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid){
        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        int enclaves = 0;
        int[][] visited = new int[n][m];

        for(int i = 0; i < m; i++){
            if(visited[0][i] == 0 && grid[0][i] == 1){
                q.add(new Pair(0, i));
                visited[0][i] = 1;
            }

            if(visited[n-1][i] == 0 && grid[n-1][i] == 1){
                q.add(new Pair(n-1, i));
                visited[n-1][i] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && grid[i][0] == 1){
                q.add(new Pair(i, 0));
                visited[i][0] = 1;
            }

            if(visited[i][m-1] == 0 && grid[i][m-1] == 1){
                q.add(new Pair(i, m-1));
                visited[i][m-1] = 1;
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] != 1 && grid[i][j] == 1){
                    enclaves += 1;
                }
            }
        }

        return enclaves;
    }
}
