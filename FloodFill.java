package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {2, 2, 0},
                {2, 2, 2}
        };

        int[][] ans = floodFill(image, 2, 0, 3);

        for(int[] i : ans){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        bfs(sr, sc, image, visited, color, initial);
        return image;
    }

    private static void bfs(int ro, int co, int[][] grid, int[][] visited, int color, int inColor){
        Queue<Pair> q = new LinkedList<Pair>();
        visited[ro][co] = 1;
        grid[ro][co] = color;
        q.add(new Pair(ro, co));

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

            int nrow = row - 1;
            int ncol = col;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == inColor && visited[nrow][ncol] == 0) {
                visited[nrow][ncol] = 1;
                grid[nrow][ncol] = color;
                q.add(new Pair(nrow, ncol));
            }

            nrow = row + 1;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == inColor && visited[nrow][ncol] == 0) {
                visited[nrow][ncol] = 1;
                grid[nrow][ncol] = color;
                q.add(new Pair(nrow, ncol));
            }

            nrow = row;
            ncol = col - 1;

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == inColor && visited[nrow][ncol] == 0) {
                visited[nrow][ncol] = 1;
                grid[nrow][ncol] = color;
                q.add(new Pair(nrow, ncol));
            }

            ncol = col + 1;
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == inColor && visited[nrow][ncol] == 0) {
                visited[nrow][ncol] = 1;
                grid[nrow][ncol] = color;
                q.add(new Pair(nrow, ncol));
            }
        }
    }
}
