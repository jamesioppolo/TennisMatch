package Tennis.Services;

import Tennis.Wrappers.ConsoleWrapper;
import Tennis.Wrappers.ScannerWrapper;
import org.junit.Test;
import org.mockito.Mockito;

public class TennisMatchApplicationTest {
	
    @Test
    public void tennisMatchApplicationCycling_matchIsNoLongerInProgress() {
        MatchScore matchScore = Mockito.mock(MatchScore.class);
        ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
        ConsoleWrapper consoleWrapper = Mockito.mock(ConsoleWrapper.class);
    }
}
