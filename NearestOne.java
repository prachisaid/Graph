package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestOne {
    static class Node{
        int first;
        int second;
        int third;

        Node(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 1}
        };

        int[][] ans = nearest(grid);

        for(int[] i : ans){
            for(int j : i){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    q.add(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;

            for(int i = 0; i < delRow.length; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps+1));
                }
            }
        }

        return dist;
    }
}
