public class _521_Longest_Uncommon_Subsequence_I {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;

        return Math.max(a.length(), b.length());
    }
}
