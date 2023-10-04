package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfProvince {
    public static void main(String[] args) {
        System.out.println(numProvincesII(adjList(), 2));
    }

    public static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V];
        int ans = 0;

        q.add(0);
        visited[0] = 1;
        ans += check(q, visited, adj);

        while(true){
            int val = checkVisited(visited);

            if(val != -1){
                q.add(val);
                visited[val] = 1;
                ans += check(q, visited, adj);
            }
            else break;
        }

        return ans;
    }

    static int checkVisited(int[] visited){
        for(int i = 0; i < visited.length; i++){
            if(visited[i] != 1) return i;
        }

        return -1;
    }

    static int check(Queue<Integer> q, int[] visited, ArrayList<ArrayList<Integer>> adj){
        while(!q.isEmpty()){
            int val = q.remove();

            ArrayList<Integer> lst = adj.get(val);

            for(int ans : lst){
                if(visited[ans] != 1){
                    q.add(ans);
                    visited[ans] = 1;
                }
            }
        }

        return 1;
    }

    private static ArrayList<ArrayList<Integer>> adjList(){
        int n = 2, m = 6;

        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i <= n; i++){
            lst.add(new ArrayList<Integer>());
        }

        lst.get(1).add(1);
        lst.get(2).add(2);


//        for(int i = 1; i < n; i++){
//            for(int j = 0; j < lst.get(i).size(); j++){
//                System.out.print(lst.get(i).get(j) + " ");
//            }
//
//            System.out.println();
//        }

        return lst;
    }

    public static int numProvincesII(ArrayList<ArrayList<Integer>> adj, int V){
        int[] visited = new int[V+1];
        int ans = 0;

        for(int i = 1; i < visited.length; i++){
            if(visited[i] == 0)
            {
                ans++;
                dfs(i, visited, adj);
            }
        }

        return ans;
    }
    private static void dfs(int val, int[] visited, ArrayList<ArrayList<Integer>> adj){
        if(visited[val] == 1) return;

        visited[val] = 1;
        ArrayList<Integer> lst = adj.get(val);

        for(int i : lst){
            if(visited[i] != 1){
                dfs(i, visited, adj);
            }
        }
    }
}
