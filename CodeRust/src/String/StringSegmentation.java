package String;

import java.util.*;

import static java.lang.System.out;

public class StringSegmentation {
    static boolean canSegmentString(String s, Set<String> dict) {
        Set<String> solved = new HashSet<>();
        return canSegmentString(s, dict, solved);
    }

    private static boolean canSegmentString(String s, Set<String> dict, Set<String> solved) {
        for (int i = 1; i <= s.length(); i++) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);

                if (second.length() == 0 || dict.contains(second)) {
                    return true;
                }

                if (!solved.contains(second)) {
                    if (canSegmentString(second, dict, solved)) {
                        return true;
                    }
                    solved.add(second);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();

        dict.add("pie");
        dict.add("pear");
        dict.add("apple");
        dict.add("peach");

        out.println("Result = " + canSegmentString("applepie", dict));
        out.println("Result = " + canSegmentString("people", dict));
    }
}