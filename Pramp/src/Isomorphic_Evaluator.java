/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving
the order of characters.

No two characters may map to the same character but a character may map to itself.

For example,
 Given "egg", "add", return true.
 Given "foo", "bar", return false.
 Given "paper", "title", return true.
*/

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Evaluator {
    public static boolean isIsomorphic(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (map.containsKey(c1)) {
                char value = map.get(c1);
                if (c2 != value)
                    return false;
            } else {
                // "abb", "fff" case
                if (map.containsValue(c2))
                    return false;

                map.put(c1, c2);
            }
        }

        return true;
    }

    public static void main() {
        System.out.println(isIsomorphic("abb", "fff")); // true
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("abca", "zbxz")); // true
        System.out.println(isIsomorphic("abab", "baba")); // true
    }
}