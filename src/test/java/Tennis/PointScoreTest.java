package Tennis;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RunWith(JUnitParamsRunner.class)
public class PointScoreTest {

    private PointScore pointScore = new PointScore();

    @Test
    @Parameters(method = "getPointScoreIncrementData")
    public void incrementScoreTest(int numIncrements, int score) {
        Stream.iterate(0, n -> n + 1)
              .limit(numIncrements)
              .forEach(x -> pointScore.increment());
        assertThat(pointScore.getScore(), is(score));
    }

    public static List<Object[]> getPointScoreIncrementData() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[] {0, 0});
        list.add(new Object[] {1, 15});
        list.add(new Object[] {2, 30});
        list.add(new Object[] {3, 40});

        return list;
    }

}
