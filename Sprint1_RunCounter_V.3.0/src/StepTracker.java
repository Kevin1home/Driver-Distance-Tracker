import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        System.out.println("Введите дату:");
        int day = scanner.nextInt();
        System.out.println("Введите кол-во шагов:");
        int qntSteps = scanner.nextInt();

        if (month <= 0 || month > 12) {
            System.out.println("Номер месяца от 1 до 12 включительно.");
            System.out.println("Ошибка ввода.");
            return;
        }
        else if (day <= 0 || day > 30) {
            System.out.println("Дата от 1 до 30 включительно.");
            System.out.println("Ошибка ввода.");
            return;
        }
        else if (qntSteps < 0) {
            System.out.println("Кол-во шагов не может быть меньше 0.");
            System.out.println("Ошибка ввода.");
            return;
        }

        MonthData monthData = monthToData[month-1];
        monthData.days[day-1] = qntSteps;

    }

    void changeStepGoal() {
        System.out.println("Введите новую цель:");
        goalByStepsPerDay = scanner.nextInt();

        if (goalByStepsPerDay < 0) {
            System.out.println("Кол-во шагов не может быть меньше 0.");
            System.out.println("Ошибка ввода.");
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца:");
        int month = scanner.nextInt();
        if (month <= 0 || month > 12) {
            System.out.println("Номер месяца от 1 до 12 включительно.");
            System.out.println("Ошибка ввода.");
            return;
        }
        System.out.println("Количество пройденных шагов по дням:");
        monthToData[month - 1].printDaysAndStepsFromMonth();

        System.out.println("Общее количество шагов за месяц:");
        System.out.println(monthToData[month - 1].sumStepsFromMonth());

        System.out.println("Максимальное пройденное количество шагов в месяце:");
        System.out.println(monthToData[month - 1].maxSteps());

        System.out.println("Среднее количество шагов:");
        int averageSteps = monthToData[month - 1].sumStepsFromMonth() / 30;
        System.out.println(averageSteps);

        System.out.println("Пройденная дистанция (в км):");
        int steps = monthToData[month - 1].sumStepsFromMonth();
        System.out.println(converter.convertToKm(steps));

        System.out.println("Количество сожжённых килокалорий:");
        System.out.println(converter.convertStepsToKilocalories(steps));

        System.out.println("Лучшая серия:");
        int finalSeries = monthToData[month - 1].bestSeries(goalByStepsPerDay);
        System.out.println(finalSeries);
    }

}
