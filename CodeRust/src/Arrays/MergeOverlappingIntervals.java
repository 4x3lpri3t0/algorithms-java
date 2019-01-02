package Arrays;

import java.util.ArrayList;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/100003
public class MergeOverlappingIntervals {
    static ArrayList<Tuple<Integer, Integer>> merge_intervals(ArrayList<Tuple<Integer, Integer>> v1) {
        if (v1 == null || v1.size() == 0) {
            return null;
        }

        ArrayList<Tuple<Integer, Integer>> v2 = new ArrayList<>();

        v2.add(new Tuple<>(v1.get(0).x, v1.get(0).y));

        for (int i = 0; i < v1.size(); i++) {
            int x1 = v1.get(i).x;
            int y1 = v1.get(i).y;
            int x2 = v2.get(v2.size() - 1).x; // Start from last added
            int y2 = v2.get(v2.size() - 1).y; // End from last added

            if (y2 >= x1) { // End of last added is bigger than current start
                // Merge
                v2.get(v2.size() - 1).y = Math.max(y1, y2);
            } else {
                v2.add(new Tuple<>(x1, y1));
            }
        }

        return v2;
    }

    public static void main(String[] args) {
        ArrayList<Tuple<Integer, Integer>> v1 = new ArrayList<Tuple<Integer, Integer>>();

        Tuple<Integer, Integer> t1 = new Tuple<Integer, Integer>(2, 10);
        Tuple<Integer, Integer> t2 = new Tuple<Integer, Integer>(4, 12);
        Tuple<Integer, Integer> t3 = new Tuple<Integer, Integer>(13, 16);
        Tuple<Integer, Integer> t4 = new Tuple<Integer, Integer>(19, 20);
        Tuple<Integer, Integer> t5 = new Tuple<Integer, Integer>(20, 24);

        v1.add(t1);
        v1.add(t2);
        v1.add(t3);
        v1.add(t4);
        v1.add(t5);

        ArrayList<Tuple<Integer, Integer>> v2 = merge_intervals(v1);

        for (int i = 0; i < v2.size(); i++) {
            out.print(String.format("{%d,%d) ", v2.get(i).x, v2.get(i).y));
        }

        out.println("\n");

        v1.clear();

        v1.add(t1);
        v1.add(t2);

        v2 = merge_intervals(v1);

        for (int i = 0; i < v2.size(); i++) {
            out.print(String.format("{%d,%d) ", v2.get(i).x, v2.get(i).y));
        }

        out.println("\n");
    }
}