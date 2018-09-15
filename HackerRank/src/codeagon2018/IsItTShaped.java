package codeagon2018;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.util.stream.Collectors.toList;

public class IsItTShaped {

    // Complete the solve function below.
    static String solve(List<List<Integer>> grid) {
        // x frequency
        Map<Integer, Integer> xs = new HashMap<>();
        // y frequency
        Map<Integer, Integer> ys = new HashMap<>();

        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;

        for (List<Integer> list : grid) {
            int x = list.get(0);
            int y = list.get(1);

            minx = min(minx, x);
            miny = min(miny, y);
            maxx = max(maxx, x);
            maxy = max(maxy, y);

            // Check that they are two lines
            // Frequency of 3 vertical points
            if (!xs.containsKey(x))
                xs.put(x, 0);
            int cur = xs.get(x);
            xs.put(x, cur + 1);
            // Frequency of 3 horizontal points
            if (!ys.containsKey(y))
                ys.put(y, 0);
            cur = ys.get(y);
            ys.put(y, cur + 1);

            if (!ys.containsValue(3) || !xs.containsValue(3))
                return "No";

            int xLine;
            for (int X : xs.keySet()) {
                if (xs.get(X) == 3)
                    xLine = X;
            }

            int yLine;
            for (int Y : ys.keySet()) {
                if (ys.get(Y) == 3)
                    yLine = Y;
            }


        }

        if (abs(minx - maxx) != 2 || abs(miny - maxy) != 2)
            return "No";

        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                List<List<Integer>> points = new ArrayList<>();

                IntStream.range(0, 5).forEach(i -> {
                    try {
                        points.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = solve(points);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
