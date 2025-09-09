package main.java;

import java.util.Scanner;

/**
 * Handles user interactions for recording mileage and managing targets.
 */
public class DistanceTracker {
    private final Scanner scanner;
    private final MonthData monthData = new MonthData();
    private int dailyTargetKm = 100;

    private final String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    public DistanceTracker(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Records mileage for a specific day and month.
     */
    public void saveDistance() {
        System.out.println("Enter kilometers driven:");
        int km = scanner.nextInt();

        System.out.println("Enter month number:");
        for (int i = 0; i < months.length; i++) {
            System.out.println((i + 1) + " - " + months[i]);
        }
        int month = scanner.nextInt();

        System.out.println("Enter day of month (1-30):");
        int day = scanner.nextInt();

        monthData.saveMonthData(new int[]{km, month, day});

        System.out.printf("Recorded: %d km on Day %d of %s.%n", km, day, months[month - 1]);
    }

    /**
     * Updates the daily mileage target.
     */
    public void changeDailyTarget() {
        System.out.println("Previous target: " + dailyTargetKm + " km/day.");
        System.out.println("Enter new target:");
        dailyTargetKm = scanner.nextInt();
        System.out.println("New daily target set: " + dailyTargetKm + " km/day.");
    }

    /**
     * Displays statistics for a specific month.
     */
    public void showStatistics() {
        System.out.println("Select month for statistics:");
        for (int i = 0; i < months.length; i++) {
            System.out.println((i + 1) + " - " + months[i]);
        }
        int month = scanner.nextInt();

        StatisticsService stats = new StatisticsService(monthData, dailyTargetKm);
        stats.printMonthlyReport(month);
    }

    public void setDailyTarget(int targetKm) {
        this.dailyTargetKm = targetKm;
    }
}
