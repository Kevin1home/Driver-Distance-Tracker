# Driver Distance Tracker

**Module: Mileage Tracking for Logistics Drivers**  
*A console-based Java application for recording and analyzing driver mileage.*

---

## Overview

This tool is designed for logistics companies to monitor driver mileage across days and months.  
It enables efficient tracking of trips, daily performance, and monthly targets.

---

## Features

- Record daily mileage (km)  
- Set and update daily mileage targets  
- View monthly statistics:
  - Total distance
  - Maximum distance per day
  - Average distance
  - Days meeting daily target  

---

## Architecture

- **`DriverDistanceTrackerApp`** – Main application entry point (console UI).  
- **`DistanceTracker`** – Manages user input, targets, and saves records.  
- **`MonthData`** – Stores mileage per month and day.  
- **`StatisticsService`** – Provides monthly statistics and analysis.  

---

## Usage

Compile and run:

```bash
javac src.main.java.DriverDistanceTrackerApp.java src.main.java.DistanceTracker.java src.main.java.MonthData.java src.main.java.StatisticsService.java
java src.main.java.Main
```

Menu options:

```
1 - Record mileage for a specific day
2 - Change daily mileage target
3 - Show monthly statistics
0 - Exit
```

---

## Example Output

```
Welcome to Driver Distance Tracker!
Please enter your initial daily mileage target (km):
150

Select an option:
1 - Record mileage for a specific day
2 - Change daily mileage target
3 - Show monthly statistics
0 - Exit

> 1
Enter kilometers driven:
200
Enter month number:
1 - January
2 - February
...
12 - December
1
Enter day of month (1-30):
5
✔ Recorded: 200 km on Day 5 of January.

> 3
Select month for statistics:
1 - January
...
--- Monthly Report ---
Total distance: 200 km
Maximum distance in a day: 200 km
Average distance per day: 6.67 km
Days meeting target (150 km): 1
```

---

## Requirements

- Java 17+  
- No external dependencies (pure standard library)

---

## License

Released under the **MIT License**.
