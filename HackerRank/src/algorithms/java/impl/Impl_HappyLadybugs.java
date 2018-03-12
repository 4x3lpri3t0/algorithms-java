package impl;

import java.util.HashMap;
import java.util.Scanner;

public class Impl_HappyLadybugs {
    public static void main() {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();

        for (int a0 = 0; a0 < Q; a0++) {
            int n = in.nextInt();
            String b = in.next();

            HashMap<Character, Integer> set = new HashMap<>();

            // Store frequencies in the hashmap
            for (int i = 0; i < n; i++) {
                char c = b.charAt(i);
                if (set.containsKey(c)) {
                    set.put(c, set.get(c) + 1);
                } else {
                    set.put(c, 1);
                }
            }

            boolean ok = true;

            // Check for singles
            for (int i = 0; i < n; i++) {
                char c = b.charAt(i);
                if (c != '_' && set.get(c) == 1) {
                    ok = false;
                }
            }

            // If no spaces, then it should be ordered
            if (!set.containsKey('_')) {
                for (int i = 0; i < n; i++) {
                    char c = b.charAt(i);
                    char prev = i > 0 ? b.charAt(i - 1) : 'a';
                    char next = (i + 1) < b.length() ? b.charAt(i + 1) : 'a';
                    if (c != prev && c != next) {
                        ok = false;
                    }
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}