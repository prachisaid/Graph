package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBinaryMaze {class Pair{
    int distance;
    int first;
    int second;

    Pair(int a, int b, int c){
        this.distance = a;
        this.first = b;
        this.second = c;
    }
}


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 0}
        };

        int[] s = {0, 1};

        int[]  dest = {2, 2};

        System.out.println(new ShortestBinaryMaze().shortestPath(grid, s, dest));
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        if(source[0] == destination[0] && source[1] == destination[1]) return 0;

        int[][] dist = new int[n][m];
        for(int[] temp : dist){
            Arrays.fill(temp, (int) 1e9);
        }
        Queue<Pair> q = new LinkedList<>();

        dist[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        int ans = -1;

        while(!q.isEmpty()){
            int dis = q.peek().distance;
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            if(dis > ans){
                ans++;
            }

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow == destination[0] && ncol == destination[1]) return ++ans;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){
                    int newDist = 1 + dis;
                    if(dist[nrow][ncol] > newDist) {
                        dist[nrow][ncol] = newDist;
                        q.add(new Pair(newDist, nrow, ncol));
                    }
                }
            }
        }

        return ans;
    }
}
