package cyclecare;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CycleCare {

    private Scanner scanner;
    private UserProfile user;
    private ArrayList<CycleRecord> cycleRecords;
    private ArrayList<SymptomEntry> symptomEntries;
    private CycleAnalyzer analyzer;

    public CycleCare() {
        scanner = new Scanner(System.in);
        cycleRecords = new ArrayList<>();
        symptomEntries = new ArrayList<>();
        analyzer = new CycleAnalyzer();
    }

    public static void main(String[] args) {
        CycleCare app = new CycleCare();
        app.createProfile();
        app.runApplication();
    }

    private void createProfile() {
        System.out.println("========================================");
        System.out.println("              CYCLECARE");
        System.out.println("   Your Personal Cycle and Wellness App");
        System.out.println("========================================");
        System.out.println();

        System.out.println("--- CREATE YOUR PROFILE ---");

        String name;

        do {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
        } while (name.isEmpty());

        int age = readNumber("Enter your age: ", 1, 120);

        System.out.print("Enter your pronouns: ");
        String pronouns = scanner.nextLine().trim();

        if (pronouns.isEmpty()) {
            pronouns = "Prefer not to say";
        }

        user = new UserProfile(name, age, pronouns);

        System.out.println();
        System.out.println("Profile created successfully!");
    }

    private void runApplication() {
        int choice;

        do {
            showMenu();
            choice = readNumber("Enter your choice: ", 0, 7);

            switch (choice) {
                case 1:
                    user.displayProfile();
                    break;

                case 2:
                    addCycleRecord();
                    break;

                case 3:
                    viewCycleRecords();
                    break;

                case 4:
                    addSymptomEntry();
                    break;

                case 5:
                    viewSymptomEntries();
                    break;

                case 6:
                    showRecommendations();
                    break;

                case 7:
                    viewCycleInsights();
                    break;

                case 0:
                    System.out.println();
                    System.out.println("Thank you for using CycleCare.");
                    System.out.println(
                            "Take care of yourself, one day at a time.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private void showMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("              CYCLECARE");
        System.out.println("========================================");
        System.out.println("[1] View My Profile");
        System.out.println("[2] Add Cycle Record");
        System.out.println("[3] View Cycle Records");
        System.out.println("[4] Add Symptom Entry");
        System.out.println("[5] View Symptom Entries");
        System.out.println("[6] Get Personalized Recommendations");
        System.out.println("[7] View Cycle Insights");
        System.out.println("[0] Exit");
        System.out.println("========================================");
    }

    private void addCycleRecord() {
        System.out.println();
        System.out.println("--- ADD CYCLE RECORD ---");

        LocalDate periodStart = readDate(
                "Enter period start date (YYYY-MM-DD): ");

        int cycleLength = readNumber(
                "Enter cycle length in days: ", 1, 60);

        CycleRecord record = new CycleRecord(
                periodStart, cycleLength);

        cycleRecords.add(record);

        System.out.println();
        System.out.println("Cycle record added successfully!");
    }

    private void viewCycleRecords() {
        System.out.println();
        System.out.println("--- CYCLE RECORDS ---");

        if (cycleRecords.isEmpty()) {
            System.out.println("No cycle records found.");
            return;
        }

        for (int i = 0; i < cycleRecords.size(); i++) {
            System.out.println();
            System.out.println("Record " + (i + 1));
            cycleRecords.get(i).displayDetails();
        }
    }

    private void addSymptomEntry() {
        System.out.println();
        System.out.println("--- ADD SYMPTOM ENTRY ---");

        LocalDate date = readDate(
                "Enter symptom date (YYYY-MM-DD): ");

        String symptom;

        do {
            System.out.print("Enter symptom: ");
            symptom = scanner.nextLine().trim();

            if (symptom.isEmpty()) {
                System.out.println("Symptom cannot be empty.");
            }
        } while (symptom.isEmpty());

        int severity = readNumber(
                "Enter symptom severity from 1 to 10: ", 1, 10);

        System.out.print("Enter mood: ");
        String mood = scanner.nextLine().trim();

        if (mood.isEmpty()) {
            mood = "Not specified";
        }

        int energyLevel = readNumber(
                "Enter energy level from 1 to 10: ", 1, 10);

        SymptomEntry entry = new SymptomEntry(
                date, symptom, severity, mood, energyLevel);

        symptomEntries.add(entry);

        System.out.println();
        System.out.println("Symptom entry added successfully!");
    }

    private void viewSymptomEntries() {
        System.out.println();
        System.out.println("--- SYMPTOM ENTRIES ---");

        if (symptomEntries.isEmpty()) {
            System.out.println("No symptom entries found.");
            return;
        }

        for (int i = 0; i < symptomEntries.size(); i++) {
            System.out.println();
            System.out.println("Symptom Entry " + (i + 1));
            symptomEntries.get(i).displayDetails();
        }
    }

    private void showRecommendations() {
        System.out.println();
        System.out.println("--- PERSONALIZED RECOMMENDATIONS ---");

        int periodDay = readNumber(
                "Enter your current period day: ", 1, 60);

        Recommendation foodRecommendation =
                new FoodRecommendation(
                        "Food and hydration", periodDay);

        Recommendation selfCareRecommendation =
                new SelfCareRecommendation(
                        "Rest and comfort", periodDay);

        System.out.println();
        System.out.println("Period day: " + periodDay);

        System.out.println();
        System.out.println(foodRecommendation.getTitle() + ":");
        System.out.println(foodRecommendation.getAdvice());

        System.out.println();
        System.out.println(selfCareRecommendation.getTitle() + ":");
        System.out.println(selfCareRecommendation.getAdvice());

        System.out.println();
        System.out.println(
                "These are general wellness suggestions only.");
    }

    private void viewCycleInsights() {
        analyzer.displayInsights(
                cycleRecords,
                symptomEntries);

        if (!cycleRecords.isEmpty()) {
            CycleRecord latestRecord =
                    cycleRecords.get(
                            cycleRecords.size() - 1);

            int currentCycleDay =
                    analyzer.calculateCycleDay(latestRecord);

            System.out.println(
                    "Current cycle day: Day "
                    + currentCycleDay);
        }
    }

    private int readNumber(
            String message, int minimum, int maximum) {

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);

                if (number >= minimum && number <= maximum) {
                    return number;
                }

                System.out.println("Please enter a number from "
                        + minimum + " to " + maximum + ".");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private LocalDate readDate(String message) {

        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return LocalDate.parse(input);

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format.");
                System.out.println("Please use YYYY-MM-DD.");
            }
        }
    }
}