import java.io.*;
import java.util.*;

public class CF898C_PhoneNumbers {
    void solve() throws Exception {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> pb = new LinkedHashMap<>();

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();

            if (!pb.containsKey(name)) {
                pb.put(name, new HashSet<>());
            }

            int numbersCount = in.nextInt();
            HashSet<String> numbers = new HashSet<>();
            for (int j = 0; j < numbersCount; j++) {
                String current = in.next();
                numbers.add(current);
            }

            pb.put(name, numbers);
        }

        for (String name : pb.keySet()) {
            HashSet<String> values = pb.get(name);

            HashSet<String> toRemove = new HashSet<>();
            for (String value : values) {
                for (String otherValue : values) {
                    if (value.lastIndexOf(otherValue) == 1) {
                        toRemove.add(otherValue);
                    }
                }
            }

            values.removeAll(toRemove);
        }

        for (String name : pb.keySet()) {
            HashSet<String> values = pb.get(name);

            System.out.println(name + " " + values.size() + values.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        new CF898C_PhoneNumbers().run();
    }

    public void run() {
        try {
            init();
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws IOException {
        String filename = "";
        if (filename.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        }
    }

    String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }

        return tok.nextToken();
    }

    int readInt() {
        return Integer.parseInt(readString());
    }

    long readLong() {
        return Long.parseLong(readString());
    }

    double readDouble() {
        return Double.parseDouble(readString());
    }
}