package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class NoOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '0'},
                {'1', '1', '0', '1'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    bfs(i, j, visited, grid);
                }
            }
        }

        return cnt;
    }

    private static void bfs(int ro, int co, int[][] visited, char[][] grid){
        Queue<Pair> q = new LinkedList<Pair>();
        visited[ro][co] = 1;
        q.add(new Pair(ro, co));

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            for(int delrow = -1; delrow <= 1; delrow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0){
                        visited[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}
