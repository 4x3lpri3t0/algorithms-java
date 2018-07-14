import java.io.*;
import java.util.*;

// https://leetcode.com/problems/judge-route-circlew

public class _657_Judge_Route_Circle {
    public static boolean judgeCircle(String moves) {
        // Initialize counters
        int x = 0;
        int y = 0;

        // Iterate and sum
        for (int i = 0; i < moves.length(); i++) {
            char current = moves.charAt(i);
            if (current == 'L') {
                x--;
            } else if (current == 'R') {
                x++;
            } else if (current == 'U') {
                y++;
            } else { // 'D'
                y--;
            }
        }

        return x == 0 && y == 0;
    }
}