package Tennis.Services;

public class PointScore {
    private Integer score = 0;
    private boolean advantage;

    public Integer getScore() {
        return score;
    }

    public boolean hasAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean hasAdvantage) {
        advantage = hasAdvantage;
    }

    public void increment() {
        switch(score) {
            case 0:
            case 15:
                score += 15;
                break;
            case 30:
                score += 10;
                break;
            default:
                break;
        }
    }

    public void reset() {
        score = 0;
        setAdvantage(false);
    }
}
