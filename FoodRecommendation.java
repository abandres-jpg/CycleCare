package cyclecare;

public class FoodRecommendation extends Recommendation {

    private int periodDay;

    public FoodRecommendation(String title, int periodDay) {
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
                return "Day 1: Drink enough water and choose warm, "
                        + "balanced meals if that feels comfortable.";

            case 2:
                return "Day 2: Try eating regular meals and include "
                        + "iron-rich foods such as leafy vegetables or beans.";

            case 3:
                return "Day 3: Continue drinking water and choose "
                        + "nutritious food that gives you steady energy.";

            case 4:
                return "Day 4: Maintain balanced meals and include "
                        + "fruits or vegetables in your food choices.";

            case 5:
                return "Day 5: Keep your meals balanced and prepare "
                        + "simple snacks or drinks for the next cycle.";

            default:
                return "Choose balanced meals, drink enough water, "
                        + "and listen to what your body needs.";
        }
    }
}