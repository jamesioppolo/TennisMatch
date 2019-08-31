package Tennis;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatchScoreTest {

    private MatchScore matchScore = new MatchScore();

    @Test
    public void initialMatch() {
        String score = matchScore.getScore();
        assertThat(score, is("0 - 0, 0 - 0"));
    }

    public static List<Object[]> getMatchScoreData() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[] {"0 - 0, 0 - 0", new Object[]{0} });

        return list;
    }

}
