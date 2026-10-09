package cyclecare;

public class SelfCareRecommendation extends Recommendation {

    private int periodDay;

    public SelfCareRecommendation(String title, int periodDay) {
        super(title);
        this.periodDay = periodDay;
    }

    public int getPeriodDay() {
        return periodDay;
    }

    @Override
    public String getAdvice() {
        switch (periodDay) {
            case 1:
                return "Day 1: Use a warm compress if you have cramps, "
                        + "stay hydrated, and rest when needed.";

            case 2:
                return "Day 2: Change your menstrual products as needed, "
                        + "get enough sleep, and try gentle stretching "
                        + "if you feel comfortable.";

            case 3:
                return "Day 3: Take a short walk if you feel comfortable, "
                        + "continue drinking water, and check your energy level.";

            case 4:
                return "Day 4: Try a relaxing activity, check in with "
                        + "your mood, and maintain your usual sleep routine.";

            case 5:
                return "Day 5: Record your symptoms, review how you felt, "
                        + "and prepare supplies for your next cycle.";

            default:
                return "Listen to your body and follow the self-care habits "
                        + "that feel comfortable for you.";
        }
    }
}