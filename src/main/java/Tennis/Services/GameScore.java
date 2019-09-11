package Tennis.Services;

import lombok.Getter;

public class GameScore {
    @Getter private Integer score = 0;

    public void increment() {
        this.score++;
    }
}
