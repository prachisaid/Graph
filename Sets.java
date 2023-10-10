package Graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<Pair> set = new HashSet<>();

        set.add(new Pair(0, 0));
        set.add(new Pair(4, 1));
        set.add(new Pair(4, 2));
        set.add(new Pair(7, 3));
        set.add(new Pair(5, 4));

        System.out.println(set);
        Iterator<Pair> it = set.iterator();

        System.out.println(it.next().first);
        it.remove();
        System.out.println(it.next().first);

        Set<Integer> set1 = new HashSet<>();
        set1.add(34);
        set1.add(1);
        set1.add(50);
        Iterator<Integer> t = set1.iterator();

        System.out.println(t.next());
        t.remove();
        System.out.println(set1);
    }
}
