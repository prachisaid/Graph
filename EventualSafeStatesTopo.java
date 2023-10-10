package Graphs;

import java.util.*;

public class EventualSafeStatesTopo {
    public static void main(String[] args) {

    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj){
        List<List<Integer>> lst = new ArrayList<>();
        int[] indegree = new int[V];

        for(int i = 0; i < V; i++){
            lst.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int adjNode : adj.get(i)){
                lst.get(adjNode).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++){
            if(indegree[i] == 0) q.add(i);
        }

        List<Integer> safe = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            safe.add(node);

            for(int adjNode : lst.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) q.add(adjNode);
            }
        }

        Collections.sort(safe);
        return safe;
    }
}
