package Graphs;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String, Integer> mapMailNode = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                if(!mapMailNode.containsKey(accounts.get(i).get(j))) {
                    mapMailNode.put(accounts.get(i).get(j), i);
                }
                else{
                    ds.unionByRank(i, mapMailNode.get(accounts.get(i).get(j)));
                }
            }
        }

        ArrayList<ArrayList<String>> mergeMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergeMail.add(new ArrayList<>());
        }

        for(Map.Entry<String, Integer> map : mapMailNode.entrySet()) {
            String mail = map.getKey();
            int node = ds.findParent(map.getValue());

            mergeMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < mergeMail.size(); i++) {
            if(mergeMail.get(i).size() == 0) continue;
            Collections.sort(mergeMail.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergeMail.get(i));
            ans.add(temp);
        }

        return ans;
    }
    public static void main(String[] args) {
        AccountsMerge obj = new AccountsMerge();

        List<List<String>> lst = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            lst.add(new ArrayList<>());
        }

        lst.get(0).add("John");
        lst.get(0).add("J1");
        lst.get(0).add("J2");
        lst.get(0).add("J3");

        lst.get(1).add("John");
        lst.get(1).add("J4");

        lst.get(2).add("Raj");
        lst.get(2).add("R1");
        lst.get(2).add("R2");

        lst.get(3).add("John");
        lst.get(3).add("J1");
        lst.get(3).add("J5");

        lst.get(4).add("Raj");
        lst.get(4).add("R2");
        lst.get(4).add("R3");

        lst.get(5).add("Mary");
        lst.get(5).add("M1");

        System.out.println(obj.accountsMerge(lst));
    }
}
