import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters

class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, l = 0, r = 0;
        while (l < n && r < n) {
            // Try to extend the range [l, r]
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            } else {
                set.add(s.charAt(r));
                r++;
                ans = Math.max(ans, r - l); // No +1 because we already r++
            }
        }

        return ans;
    }
}