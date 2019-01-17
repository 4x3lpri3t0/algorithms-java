import java.io.*;
import java.util.*;

import static java.lang.Math.*;

// http://codeforces.com/problemset/problem/448/B
// https://codeforces.com/blog/entry/13042
public class CF448B_SuffixStructures extends PrintWriter {
    private boolean isSubsequenceOf(String t, String s) {
        int lastTIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char tChar = t.charAt(lastTIndex);
            char sChar = s.charAt(i);

            if (sChar == tChar) {
                lastTIndex++;

                if (lastTIndex == t.length() - 1)
                    return true;
            }
        }

        return false;
    }

    private void addToMap(String str, Map<Character, Integer> map) {
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (!map.containsKey(cur))
                map.put(cur, 0);
            map.put(cur, map.get(cur) + 1);
        }
    }

    public void solve() throws IOException {
        String s = read();
        String t = read();

        // TODO: Doesn't work for inputs:
        //  wkfoyetcjivofxaktmauapzeuhcpzjloszzxwydgavebgniiuzrscytsokjkjfkpylvxtlqlquzduywbhqdzmtwprfdohmwgmysy
        //  z
        if (t.length() <= s.length() && isSubsequenceOf(t, s)) {
            println("automaton");
            return;
        }

        // Hashmap in which we store chars of s and chars of t
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        addToMap(s, sMap);
        addToMap(t, tMap);

        // Create set of characters in s string
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        // If char in s exists in t, remove from both
        for (Character key : set) {
            if (tMap.containsKey(key) && sMap.containsKey(key)) {
                int sCount = sMap.get(key);
                int tCount = tMap.get(key);
                if (sCount == tCount) {
                    sMap.remove(key);
                    tMap.remove(key);
                } else if (sCount > tCount) {
                    sMap.put(key, sCount - tCount);
                    tMap.remove(key);
                } else {
                    tMap.put(key, tCount - sCount);
                    sMap.remove(key);
                }
            }
        }

        // Both t set and s set have now length 0?
        if (sMap.size() == 0 && tMap.size() == 0) {
            println("array");
            return;
        }

        // Only t set has length 0?
        if (tMap.size() == 0) {
            println("both");
            return;
        }

        // Otherwise (both still have elements)
        println("need tree");
    }

    BufferedReader in;
    StringTokenizer stok;

    public void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(abs(-1));
        }
    }

    CF448B_SuffixStructures() {
        super(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignored) {
        }
        new CF448B_SuffixStructures().run();
    }

    String read() throws IOException {
        while (stok == null || !stok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            stok = new StringTokenizer(s);
        }
        return stok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(read());
    }

    long readLong() throws IOException {
        return Long.parseLong(read());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(read());
    }

    int[] readIntArray(int len) throws IOException {
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = readInt();
        }
        return a;
    }

    <T> List<T>[] createAdjacencyList(int countVertex) {
        List<T>[] res = new List[countVertex];
        for (int i = 0; i < countVertex; i++) {
            res[i] = new ArrayList<T>();
        }
        return res;
    }
}