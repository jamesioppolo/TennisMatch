package Tennis;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RunWith(JUnitParamsRunner.class)
public class MatchScoreTest {

    private MatchScore matchScore = new MatchScore();

    @Test
    @Parameters(method = "getMatchScoreData")
    public void executeMatchSequence(String matchResult, List<Integer> scores) {
        Stream.iterate(0, n -> n + 1)
                .limit(scores.size())
                .forEach(x -> matchScore.pointWonBy(Player.fromInteger(scores.get(x))));
        assertThat(matchScore.getScore(), is(matchResult));
    }

    public static List<Object[]> getMatchScoreData() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[] {"0 - 0, 0 - 0", new ArrayList<Player>() });
        list.add(new Object[] {"0 - 0, 15 - 0", new ArrayList<>( Arrays.asList(1)) });
        list.add(new Object[] {"0 - 0, 30 - 0", new ArrayList<>( Arrays.asList(1, 1)) });
        list.add(new Object[] {"0 - 0, 40 - 0", new ArrayList<>( Arrays.asList(1, 1, 1)) });
        list.add(new Object[] {"0 - 0, 40 - 15", new ArrayList<>( Arrays.asList(1, 1, 1, 2)) });
        list.add(new Object[] {"0 - 0, Deuce",        new ArrayList<>( Arrays.asList(1, 1, 1, 2, 2, 2)) });
        list.add(new Object[] {"0 - 0, Adv Player 2", new ArrayList<>( Arrays.asList(1, 1, 1, 2, 2, 2, 2)) });
        list.add(new Object[] {"0 - 0, Deuce",        new ArrayList<>( Arrays.asList(1, 1, 1, 2, 2, 2, 2, 1)) });
        list.add(new Object[] {"0 - 1, 0 - 0",        new ArrayList<>( Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2)) });
        list.add(new Object[] {"0 - 0, Adv Player 1", new ArrayList<>( Arrays.asList(1, 1, 1, 2, 2, 2, 2, 1, 1)) });

        return list;
    }
}
