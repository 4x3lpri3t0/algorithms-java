import static java.lang.System.out;

public class _1_5_Compression {
    public static String compression(String oldStr) {
        StringBuilder sb = new StringBuilder();
        int prevCount = 1;
        char prevChar = oldStr.charAt(0);

        for (int i = 1; i < oldStr.length(); i++) {
            char curChar = oldStr.charAt(i);

            if (curChar != prevChar) {
                sb.append(prevChar);
                sb.append(prevCount);
                prevChar = curChar;
                prevCount = 1;
            } else {
                prevCount++;
            }
        }

        sb.append(prevChar);
        sb.append(prevCount);

        String newStr = sb.toString();
        if (newStr.length() >= oldStr.length()) {
            return oldStr;
        }

        return newStr;
    }

    public static void main() {
        String str = "abbccccccde";
        String c = compression(str);
        out.println(c);

        str = "aaaaa";
        c = compression(str);
        out.println(c);

        str = "abcd";
        c = compression(str);
        out.println(c);
    }
}