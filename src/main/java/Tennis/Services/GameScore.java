package Tennis.Services;

public class GameScore {
    private Integer score = 0;

    public Integer getScore() {
        return this.score;
    }

    public void increment() {
        this.score++;
    }
}
