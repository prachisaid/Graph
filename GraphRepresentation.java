package Graphs;

import java.util.ArrayList;

public class GraphRepresentation {
    public static void main(String[] args) {
//        adjMatrix();
        adjList();
    }

    private static void adjMatrix(){
        int n = 3, m = 3;

        int adj[][] = new int[n+1][n+1];

        adj[1][2] = 1;
        adj[2][1] = 1;

//        System.out.println(adj);
        for(int[] arr : adj){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    private static void adjList(){
        int n = 5, m = 6;

        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++){
            lst.add(new ArrayList<Integer>());
        }

        lst.get(1).add(2);
        lst.get(2).add(1);

        lst.get(1).add(3);
        lst.get(3).add(1);

        lst.get(3).add(4);
        lst.get(4).add(3);

        lst.get(4).add(5);
        lst.get(5).add(4);

        lst.get(2).add(4);
        lst.get(4).add(2);

        lst.get(2).add(5);
        lst.get(5).add(2);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < lst.get(i).size(); j++){
                System.out.print(lst.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }
}
