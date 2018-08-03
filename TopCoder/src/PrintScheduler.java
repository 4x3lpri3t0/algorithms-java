// https://arena.topcoder.com/index.html#/u/practiceCode/1497/4162/4504/2/1497

public class PrintScheduler {

    public String getOutput(String[] threads, String[] slices) {
        StringBuilder output = new StringBuilder();

        for (String slice : slices) {
            String fields[] = slice.split(" ");
            int threadIdx = Integer.parseInt(fields[0]);
            String thread = threads[threadIdx];
            int time = Integer.parseInt(fields[1]);

            for (int i = 0; i < time; i++) {
                char threadChar = thread.charAt(i % thread.length());
                output.append(threadChar);
            }
        }

        return output.toString();
    }
}