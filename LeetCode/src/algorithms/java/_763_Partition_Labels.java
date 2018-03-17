import java.io.*;
import java.util.*;

// https://leetcode.com/problems/partition-labels

public class _763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];

        // Store last seen position for char
        for (int i = 0; i < S.length(); ++i) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0;
        int anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}