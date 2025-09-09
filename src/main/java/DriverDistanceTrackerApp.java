package main.java;
import java.util.Scanner;

/**
 * Entry point for the Driver Distance Tracker application.
 *
 * A console-based system that allows to track
 * drivers' daily mileage, adjust monthly targets, and analyze statistics.
 */
public class DriverDistanceTrackerApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DistanceTracker tracker = new DistanceTracker(scanner);

        System.out.println("Welcome to Driver Distance Tracker!");
        System.out.println("Please enter your initial daily mileage target (km):");
        tracker.setDailyTarget(scanner.nextInt());

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> tracker.saveDistance();
                case 2 -> tracker.changeDailyTarget();
                case 3 -> tracker.showStatistics();
                case 0 -> {
                    System.out.println("Exiting Driver Distance Tracker. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid command. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1 - Record mileage for a specific day");
        System.out.println("2 - Change daily mileage target");
        System.out.println("3 - Show monthly statistics");
        System.out.println("0 - Exit");
    }
}