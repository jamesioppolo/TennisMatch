package Tennis.Services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameScoreTest {

    private GameScore gameScore = new GameScore();

    @Test
    public void incrementScoreWorks() {
        this.gameScore.increment();
        assertThat(this.gameScore.getScore(), is(1));
    }
}
