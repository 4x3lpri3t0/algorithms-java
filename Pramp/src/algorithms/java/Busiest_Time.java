/*
#Busiest Time in The Mall

The mall management is trying to figure out what was the busiest moment in the mall in the last year.
You are given data from the door detectors: each data entry includes a timestamp
(seconds in Unix Epoch format), an amount of people and whether they entered or exited.

Example of a data entry: { time: 1440084737, count: 4, type: "enter" }

Find what was the busiest period in the mall on the last year.
Return an array with two Epoch timestamps representing the beginning and end of that period.
You may assume that the data your are given is accurate and that each second with entries or
exits is recorded. Implement the most efficient solution possible and analyze its time and space complexity.
 */

import java.util.Arrays;

public class Busiest_Time {
    private class Data implements Comparable<Data> {
        long time;
        int count;
        boolean enter;

        public Data(long t, int c, boolean e) {
            time = t;
            count = c;
            enter = e;
        }

        public int compareTo(Data that) {
            return Long.compare(this.time, that.time);
        }
    }

    public static long[] getBusiestTime(Data[] arr) {
        long[] result = new long[2];
        if (arr == null || arr.length == 0) {
            return null;
        }

        // Sort array by time
        Arrays.sort(arr);

        int max = 0;
        int cur = 0;
        int len = arr.length - 1;

        for (int i = 0; i <= len; i++) {
            if (arr[i].enter) {
                cur += arr[i].count;
            } else {
                cur -= arr[i].count;
            }

            if (i < len && arr[i].time == arr[i + 1].time) {
                continue;
            }

            if (cur > max) {
                max = cur;
                result[0] = arr[i].time;

                if (i < len) {
                    result[1] = arr[i + 1].time;
                } else {
                    result[1] = arr[i].time;
                }
            }
        }

        return result;
    }

    public void main(String[] args) {
        Data[] info = new Data[10];
        info[0] = new Data(1, 2, false);
        info[1] = new Data(2, 2, true);
        info[2] = new Data(21, 2, true);
        info[3] = new Data(13, 2, true);
        info[4] = new Data(1, 2, true);
        info[5] = new Data(34, 2, false);
        info[6] = new Data(3, 2, false);
        info[7] = new Data(55, 2, false);
        info[8] = new Data(5, 2, true);
        info[9] = new Data(8, 2, false);

        long[] result = getBusiestTime(info);
        System.out.println(result[0] + " to " + result[1]);
    }
}