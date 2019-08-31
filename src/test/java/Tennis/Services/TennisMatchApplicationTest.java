package Tennis.Services;

import Tennis.Wrappers.ConsoleWrapper;
import Tennis.Wrappers.ScannerWrapper;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TennisMatchApplicationTest {
	
    @Test
    public void tennisMatchApplicationCyclingStops_whenMatchIsFinished() {
        // arrange
        MatchScore matchScore = Mockito.mock(MatchScore.class);
        doReturn(true).doReturn(true).doReturn(false).when(matchScore).isMatchInProgress();
        doReturn("testScoreString1").doReturn("matchIsFinished").when(matchScore).getScore();

        ScannerWrapper scannerWrapper = Mockito.mock(ScannerWrapper.class);
        doReturn(1).doReturn(2).when(scannerWrapper).nextInt();

        ConsoleWrapper consoleWrapper = Mockito.mock(ConsoleWrapper.class);
        TennisMatchApplication app = new TennisMatchApplication(matchScore, scannerWrapper, consoleWrapper);
        ArgumentCaptor<String> consoleLogs = ArgumentCaptor.forClass(String.class);

        // act
        app.start();

        // assert
        verify(consoleWrapper, times(5)).printLine(consoleLogs.capture());
        System.out.println(consoleLogs.getAllValues().get(1));
        assertEquals(consoleLogs.getAllValues().get(0), "Tennis Match Application");
        assertEquals(consoleLogs.getAllValues().get(1), "Enter Player (1 or 2)>");
        assertEquals(consoleLogs.getAllValues().get(2), "testScoreString1");
        assertEquals(consoleLogs.getAllValues().get(3), "Enter Player (1 or 2)>");
        assertEquals(consoleLogs.getAllValues().get(4), "matchIsFinished");
    }
}
