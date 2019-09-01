package Tennis.Services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import Tennis.Services.PointScore;
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
    public void incrementScoreTest(Integer numIncrements, Integer score) {
        Stream.iterate(0, n -> n + 1)
              .limit(numIncrements)
              .forEach(x -> this.pointScore.increment());
        assertThat(this.pointScore.getScore(), is(score));
    }

    @Test
    public void resetScoreTest() {
        this.pointScore.increment();
        this.pointScore.increment();
        this.pointScore.increment();
        this.pointScore.increment();
        this.pointScore.increment();
        this.pointScore.reset();
        assertThat(this.pointScore.getScore(), is(0));
        assertThat(this.pointScore.hasAdvantage(), is(false));
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
