package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int m = 6, n = 5;
        new AdjacencyMatrix().adjMat(m, n);
    }

    private void adjMat(int m, int n) {
        int[][] adj = new int[n + 1][n + 1];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter edges");
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        print(adj);
    }

    private void print(int[][] adj) {
        for(int[] lst : adj) {
            System.out.println(Arrays.toString(lst));
        }
    }
}
