package Graphs;

import java.util.Arrays;

public class SmallestCityFloyd {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 3, -1, -1},
                {3, 0, 1, 1},
                {-1, 1, 0, 1},
                {-1, 4, 1, -1}
        };

        new SmallestCityFloyd().findTheCity(4, matrix, 4);
        for(int[] mat : matrix) {
            System.out.println(Arrays.toString(mat));
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) matrix[i][j] = 0;
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] edge : edges){
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    matrix[i][j] = Math.min(matrix[i][j] , (matrix[i][k] + matrix[k][j]));
                }
            }
        }

        int cntMax = n;
        int city = -1;
        for(int i = 0; i < n; i++){
            int cnt = 0;

            for(int j = 0; j < n; j++){
                if(matrix[i][j] <= distanceThreshold) cnt++;
            }

            if(cnt <= cntMax){
                cntMax = cnt;
                city = i;
            }
        }

        return city;
    }
}
