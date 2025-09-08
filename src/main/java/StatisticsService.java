package main.java;

import java.util.Arrays;

/**
 * Provides statistics and analysis of mileage
 */
public class StatisticsService {
    private final MonthData monthData;
    private final int dailyTargetKm;

    public StatisticsService(MonthData monthData, int dailyTargetKm) {
        this.monthData = monthData;
        this.dailyTargetKm = dailyTargetKm;
    }

    /**
     * Prints a monthly mileage report.
     *
     * @param month month index (1..12)
     */
    public void printMonthlyReport(int month) {
        int[] distances = monthData.getMonthData(month);

        int total = Arrays.stream(distances).sum();
        int max = Arrays.stream(distances).max().orElse(0);
        double average = Arrays.stream(distances).average().orElse(0);

        System.out.println("\n--- Monthly Report ---");
        System.out.println("Total distance: " + total + " km");
        System.out.println("Maximum distance in a day: " + max + " km");
        System.out.printf("Average distance per day: %.2f km%n", average);

        long daysMeetingTarget = Arrays.stream(distances).filter(d -> d >= dailyTargetKm).count();
        System.out.println("Days meeting target (" + dailyTargetKm + " km): " + daysMeetingTarget);
    }
}
