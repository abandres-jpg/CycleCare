package cyclecare;

import java.time.LocalDate;

public class SymptomEntry implements Displayable {

    private LocalDate date;
    private String symptom;
    private int severity;
    private String mood;
    private int energyLevel;

    public SymptomEntry(LocalDate date, String symptom, int severity,
            String mood, int energyLevel) {
        this.date = date;
        this.symptom = symptom;
        this.severity = severity;
        this.mood = mood;
        this.energyLevel = energyLevel;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSymptom() {
        return symptom;
    }

    public int getSeverity() {
        return severity;
    }

    public String getMood() {
        return mood;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Date: " + date);
        System.out.println("Symptom: " + symptom);
        System.out.println("Severity: " + severity + "/10");
        System.out.println("Mood: " + mood);
        System.out.println("Energy level: " + energyLevel + "/10");
    }
}