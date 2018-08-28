package String;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class RemoveDuplicates {
    static void remove_duplicates(char[] str) {
        HashSet<Character> chars = new HashSet<>();

        for (int i = 0; i < str.length; i++) {
            char cur = str[i];
            if (!chars.contains(cur)) {
                chars.add(cur);
                System.out.print(cur);
            }
        }
    }

    public static void main(String[] args) {
        remove_duplicates("abbabcddbabcdeedebc".toCharArray());
    }
}