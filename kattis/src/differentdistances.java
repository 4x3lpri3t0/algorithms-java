import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class differentdistances {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        while (true) {
            String[] data = reader.readLine().split(" ");

            double x1 = Double.parseDouble(data[0]);
            if (x1 == 0) {
                break;
            }

            double y1 = Double.parseDouble(data[1]);
            double x2 = Double.parseDouble(data[2]);
            double y2 = Double.parseDouble(data[3]);
            double p = Double.parseDouble(data[4]);

            double pNormDistance = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1 / p);
            out.println(pNormDistance);
        }

        out.println();
    }
}