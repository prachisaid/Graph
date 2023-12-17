package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostStonesRemoved {

    class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for(int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if(parent.get(node) == node) {
                return node;
            }

            parent.set(parent.get(node), findParent(parent.get(node)));
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            if(ulp_u == ulp_v) return;

            if(size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            }
            else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
            }
        }
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for(int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < stones.length; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }

        int cnt = 0;

        for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if(ds.findParent(mp.getKey()) == mp.getKey()) {
                cnt++;
            }
        }

        return (stones.length - cnt);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        };

        MostStonesRemoved obj = new MostStonesRemoved();
        System.out.println(obj.removeStones(arr));
    }
}

