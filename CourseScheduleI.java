package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {
    public static void main(String[] args) {

    }

    public boolean isPossible(int N, int P, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < P; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[N];

        for(int i = 0; i < N; i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> lst = new ArrayList<>();
        int i = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            lst.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(lst.size() == N) return true;
        return false;
    }
}
