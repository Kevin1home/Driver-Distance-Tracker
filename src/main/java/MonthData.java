package main.java;

/**
 * Stores mileage data for each day of the year.
 */
public class MonthData {
    private final int[][] distanceData = new int[12][31]; // 12 months × 30 days

    /**
     * Saves daily mileage.
     *
     * @param newData array format: {km, month, day}
     */
    public void saveMonthData(int[] newData) {
        int km = newData[0];
        int month = newData[1] - 1;
        int day = newData[2] - 1;
        distanceData[month][day] += km;
    }

    /**
     * Retrieves all mileage data for a given month.
     *
     * @param month month index (1..12)
     * @return array of distances
     */
    public int[] getMonthData(int month) {
        return distanceData[month - 1];
    }
}
