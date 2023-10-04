package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    public static void main(String[] args) {
        System.out.println(bfsOfGraph(8, adjList()));
//        adjList();
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V+1]; //we can also create a boolean array for this
        ArrayList<Integer> bfs = new ArrayList<>();

        q.add(1);
        visited[1] = 1;

        while(!q.isEmpty()){
            int val = q.remove();
            bfs.add(val);

            ArrayList<Integer> lst = adj.get(val);

            for(int ans : lst){
                if(visited[ans] != 1){
                    q.add(ans);
                    visited[ans] = 1;
                }
            }
        }

        return bfs;
    }
    private static ArrayList<ArrayList<Integer>> adjList(){
        int n = 8, m = 6;

        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++){
            lst.add(new ArrayList<Integer>());
        }

        lst.get(1).add(2);
        lst.get(2).add(1);

        lst.get(1).add(6);
        lst.get(6).add(1);

        lst.get(2).add(3);
        lst.get(3).add(2);

        lst.get(2).add(4);
        lst.get(4).add(2);

        lst.get(5).add(4);
        lst.get(4).add(5);

        lst.get(5).add(7);
        lst.get(7).add(5);

        lst.get(6).add(7);
        lst.get(7).add(6);

        lst.get(6).add(8);
        lst.get(8).add(7);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < lst.get(i).size(); j++){
                System.out.print(lst.get(i).get(j) + " ");
            }

            System.out.println();
        }

        return lst;
    }
}
