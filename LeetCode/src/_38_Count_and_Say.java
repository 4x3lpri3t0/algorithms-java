// https://leetcode.com/problems/count-and-say

class _38_Count_and_Say {
    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer("1");
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuffer temp = new StringBuffer();
            int len = sb.length();
            for (int j = 1; j < len; j++) {
                if (sb.charAt(j) != sb.charAt(j - 1)) {
                    temp.append(count);
                    temp.append(sb.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }

            temp.append(count);
            temp.append(sb.charAt(len - 1));
            sb = temp;
        }

        return sb.toString();
    }
}