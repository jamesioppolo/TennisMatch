package Tennis;

public class PointScore {
    private int score;
    private boolean advantage;

    public int getScore() {
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
}
