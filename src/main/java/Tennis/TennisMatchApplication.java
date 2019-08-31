package Tennis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TennisMatchApplication {

	@Autowired
	private final MatchScore matchScore;

	Scanner keyboard = new Scanner(System.in);

	public TennisMatchApplication(MatchScore matchScore) {
		this.matchScore = matchScore;
	}

	public void start() {
		System.out.println("Tennis Match Application");
		while(matchScore.isMatchInProgress()) {
			System.out.println("Enter Player (1 or 2)>");
			int keyPressInteger = keyboard.nextInt();
			if (keyPressInteger == 1 || keyPressInteger == 2) {
				matchScore.pointWonBy(Player.fromInteger(keyPressInteger));
			} else {
				System.out.println("Invalid input.");
			}
			System.out.println(matchScore.getScore());
		}
	}
}
