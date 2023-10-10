package Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    class Pair{
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

    }

    int MinimumEffort(int heights[][]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m  = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] d : dist){
            Arrays.fill(d, (int) 1e9);
        }

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        while(!pq.isEmpty()){
            int diff = pq.peek().distance;
            int row = pq.peek().first;
            int col = pq.peek().second;

            pq.remove();

            if(row == n-1 && col == m-1) return diff;

            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int nEffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if(nEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = nEffort;
                        pq.add(new Pair(nEffort, nrow, ncol));
                    }
                }
            }
        }

        return 0;
    }
}
