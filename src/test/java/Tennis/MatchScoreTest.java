package Tennis;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MatchScoreTest {

    private MatchScore matchScore = new MatchScore();

    @Test
    public void greeterSaysHello() {
        assertThat(matchScore.playerOneScore, is(0));
    }

}
