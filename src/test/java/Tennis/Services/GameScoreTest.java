package Tennis.Services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import Tennis.Services.GameScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class GameScoreTest {

    private GameScore gameScore = new GameScore();

    @Test
    public void incrementScoreWorks() {
        this.gameScore.increment();
        assertThat(this.gameScore.getScore(), is(1));
    }
}
