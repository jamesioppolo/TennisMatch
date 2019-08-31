package Tennis.Services;

import Tennis.Wrappers.ScannerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisMatchApplication {

	@Autowired
	private final MatchScore matchScore;

	@Autowired
	private final ScannerWrapper scanner;

	public TennisMatchApplication(MatchScore matchScore,
								  ScannerWrapper scanner) {
		this.matchScore = matchScore;
		this.scanner = scanner;
	}

	public void start() {
		System.out.println("Tennis Match Application");
		while(matchScore.isMatchInProgress()) {
			System.out.println("Enter Player (1 or 2)>");
			int keyPressInteger = scanner.nextInt();
			if (keyPressInteger == 1 || keyPressInteger == 2) {
				matchScore.pointWonBy(Player.fromInteger(keyPressInteger));
			} else {
				System.out.println("Invalid input.");
			}
			System.out.println(matchScore.getScore());
		}
	}
}
