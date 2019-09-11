package Tennis.Services;

import lombok.Getter;
import lombok.Setter;

public class PointScore {
    @Getter private Integer score = 0;
    private boolean advantage = false;

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
                this.score += 15;
                break;
            case 30:
                this.score += 10;
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
