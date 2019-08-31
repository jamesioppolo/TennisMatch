package Tennis.Services;

public class GameScore {
    private Integer score = 0;

    public Integer getScore() {
        return score;
    }

    public void increment() {
        score++;
    }
}
