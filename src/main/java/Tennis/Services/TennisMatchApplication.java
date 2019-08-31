package Tennis.Services;

import Tennis.Wrappers.ConsoleWrapper;
import Tennis.Wrappers.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisMatchApplication {

	@Autowired
	private final MatchScore matchScore;

	@Autowired
	private final ScannerWrapper scanner;

	@Autowired
	private final ConsoleWrapper consoleWrapper;

	public TennisMatchApplication(MatchScore matchScore,
								  ScannerWrapper scanner,
								  ConsoleWrapper consoleWrapper) {
		this.matchScore = matchScore;
		this.scanner = scanner;
		this.consoleWrapper = consoleWrapper;
	}

	public void start() {
		consoleWrapper.printLine("Tennis Match Application");
		while(matchScore.isMatchInProgress()) {
			consoleWrapper.printLine("Enter Player (1 or 2)>");
			int keyPressInteger = scanner.nextInt();
			if (keyPressInteger == 1 || keyPressInteger == 2) {
				matchScore.pointWonBy(Player.fromInteger(keyPressInteger));
			} else {
				consoleWrapper.printLine("Invalid input.");
			}
			consoleWrapper.printLine(matchScore.getScore());
		}
	}
}
