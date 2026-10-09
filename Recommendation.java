package cyclecare;

public abstract class Recommendation {

    private String title;

    public Recommendation(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getAdvice();
}