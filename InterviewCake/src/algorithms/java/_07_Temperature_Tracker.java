class _07_Temperature_Tracker {
    // for mean
    private int numberOfReadings;
    private long totalSum;
    private double mean;

    // for min and max
    private int minTemp = Integer.MAX_VALUE;
    private int maxTemp = Integer.MIN_VALUE;

    public void insert(int temperature) {

        // for mean
        numberOfReadings++;
        totalSum += temperature;
        mean = (double) totalSum / numberOfReadings;

        // for min and max
        minTemp = Math.min(minTemp, temperature);
        maxTemp = Math.max(maxTemp, temperature);
    }

    public int getMax() {
        return maxTemp;
    }

    public int getMin() {
        return minTemp;
    }

    public double getMean() {
        return mean;
    }
}
// O(1) time
// O(1) space