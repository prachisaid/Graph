package Graphs;

import java.util.*;

public class MinimumMultiplication {
    public static void main(String[] args) {
        int[] arr = {3, 4, 65};

        System.out.println(new MinimumMultiplication().minimumMultiplications(arr, 7, 66175));
    }

    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));

        int[] dist = new int[100000];
        Arrays.fill(dist, (int)(1e9));
        dist[start] = 0;

        int mod = 100000;

        while(!q.isEmpty()){
            int steps = q.peek().first;
            int val = q.peek().second;
            q.remove();

            for (int j : arr) {
                int tempval = (val * j) % mod;

                if(dist[tempval] > steps + 1){
                    q.add(new Pair(steps + 1, tempval));
                    if(tempval == end) return steps + 1;
                    dist[tempval] = steps + 1;
                }
            }
        }

        return -1;
    }
}
