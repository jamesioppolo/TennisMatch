package Tennis;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class GameScoreTest {

    private GameScore gameScore = new GameScore();

    @Test
    public void incrementScoreWorks() {
        gameScore.increment();
        assertThat(gameScore.getScore(), is(1));
    }
}
