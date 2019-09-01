package Tennis.Services;

public class PointScore {
    private Integer score = 0;
    private boolean advantage;

    public Integer getScore() {
        return this.score;
    }

    public boolean hasAdvantage() {
        return this.advantage;
    }

    public void setAdvantage(boolean hasAdvantage) {
        this.advantage = hasAdvantage;
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
        this.score = 0;
        this.setAdvantage(false);
    }
}
