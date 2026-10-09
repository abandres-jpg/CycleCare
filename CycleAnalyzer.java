package cyclecare;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class CycleAnalyzer {

    public double calculateAverageCycleLength(
            ArrayList<CycleRecord> records) {

        if (records.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (CycleRecord record : records) {
            total += record.getCycleLength();
        }

        return (double) total / records.size();
    }

    public int calculateCycleDay(CycleRecord record) {
        long daysPassed = ChronoUnit.DAYS.between(
                record.getPeriodStart(),
                LocalDate.now());

        return (int) daysPassed + 1;
    }

    public void displayInsights(
            ArrayList<CycleRecord> cycleRecords,
            ArrayList<SymptomEntry> symptomEntries) {

        System.out.println();
        System.out.println("--- CYCLE INSIGHTS ---");

        if (cycleRecords.isEmpty()) {
            System.out.println("No cycle records yet.");
        } else {
            double average = calculateAverageCycleLength(
                    cycleRecords);

            System.out.printf(
                    "Average cycle length: %.1f days%n",
                    average);

            System.out.println(
                    "Total cycle records: "
                    + cycleRecords.size());
        }

        if (symptomEntries.isEmpty()) {
            System.out.println("No symptom entries yet.");
        } else {
            System.out.println(
                    "Total symptom entries: "
                    + symptomEntries.size());

            SymptomEntry latestEntry =
                    symptomEntries.get(
                            symptomEntries.size() - 1);

            System.out.println(
                    "Most recent symptom: "
                    + latestEntry.getSymptom());
        }
    }
}