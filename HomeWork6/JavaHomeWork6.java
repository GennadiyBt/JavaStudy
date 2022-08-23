import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class JavaHomeWork6 {
    public static <T> void main(String[] args) {
        HashSet <Integer> hs = new HashSet<>();
        LinkedHashSet <Integer> lhs = new LinkedHashSet<>();
        TreeSet <Integer> ts = new TreeSet<>();

        while (hs.size()<10 || lhs.size()<10 || ts.size()<10) { // Блок обеспечивает заполнение каждого сета ровно 10 элементами.
            if (hs.size()<10) {
                hs.add((int) (Math.random() * 100));
            }
            if (lhs.size()<10) {
                lhs.add((int) (Math.random() * 100));
            }
            if (ts.size()<10) {
                ts.add((int) (Math.random() * 100));
            }
        }
        System.out.println(hs);
        System.out.println(lhs);
        System.out.println(ts);

        Iterator <Integer> iter_hs = hs.iterator();
        while (iter_hs.hasNext()) {
            if (lhs.contains(iter_hs.next())) {
                iter_hs.remove();
            }
        }
        System.out.println(hs);

        for (Integer e : lhs) {
            if (ts.add(e)) {ts.add(e);}
        }
        System.out.println(ts);

        TreeSet <Integer> ts1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (integer == t1) return 0;
                if (t1%2 == 0) return -1; else return 1;
            }    
        });
        while (ts1.size()<15) {
            ts1.add((int) (Math.random() * 100)); 
        }
        System.out.println(ts1);

        TreeMap <Integer, Integer> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (integer == t1) return 0;
                if (t1%2 == 0) return -1; else return 1;
            }
        });

        for (int i = 0; i < 15; i++) {
            int v = (int) (Math.random() * 100 - 50);
            tm.put(i, v);
        }
        System.out.println(tm);

    }

    
}