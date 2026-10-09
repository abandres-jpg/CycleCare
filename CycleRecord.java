package cyclecare;

import java.time.LocalDate;

public class CycleRecord implements Displayable {

    private LocalDate periodStart;
    private int cycleLength;

    public CycleRecord(LocalDate periodStart, int cycleLength) {
        this.periodStart = periodStart;
        this.cycleLength = cycleLength;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public LocalDate calculateNextPeriod() {
        return periodStart.plusDays(cycleLength);
    }

    @Override
    public void displayDetails() {
        System.out.println("Period start: " + periodStart);
        System.out.println("Cycle length: " + cycleLength + " days");
        System.out.println("Estimated next period: "
                + calculateNextPeriod());
    }
}