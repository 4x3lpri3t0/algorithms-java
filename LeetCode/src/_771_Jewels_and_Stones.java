import java.io.*;
import java.util.*;

// https://leetcode.com/problems/jewels-and-stones

public class _771_Jewels_and_Stones {
    public static int numJewelsInStones(String J, String S) {
        int total = 0;
        for (int i = 0; i < S.length(); i++) {
            Character current = S.charAt(i);

            if (J.indexOf(current) != -1)
                total++;
        }

        return total;
    }
}