package Tennis.Services;

import Tennis.Wrappers.ConsoleWrapper;
import Tennis.Wrappers.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
		this.consoleWrapper.printLine("Tennis Match Application");
		while(this.matchScore.isMatchInProgress()) {
			this.consoleWrapper.printLine("Enter Player (1 or 2)>");
			Integer keyPressInteger = this.scanner.nextInt();
			if (keyPressInteger.equals(1) || keyPressInteger.equals(2)) {
				this.matchScore.pointWonBy(Player.fromInteger(keyPressInteger));
			} else {
				this.consoleWrapper.printLine("Invalid input.");
			}
			this.consoleWrapper.printLine(this.matchScore.getScore());
		}
	}
}
