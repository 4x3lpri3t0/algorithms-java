import java.io.*;
import java.util.*;

// https://leetcode.com/problems/hamming-distance

class _461_Hamming_Distance {
    public int hammingDistance(int a, int b) {
        int val = a ^ b;
        int dist = 0;

        while (val != 0) {
            // https://stackoverflow.com/a/48437787/1216218
            val = val & (val-1);
            dist++;
        }

        return dist;
    }
}