import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class autori {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String[] strings = br.readLine().split("-");
        String s = strings[0].charAt(0) + "";
        for (int i = 1; i < strings.length; i++) {
            s += strings[i].charAt(0);
        }

        out.println(s);
    }
}