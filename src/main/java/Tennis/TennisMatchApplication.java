package Tennis;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TennisMatchApplication {
	MatchScore matchScore = new MatchScore();
	Scanner keyboard = new Scanner(System.in);

	public void start() {
		System.out.println("Tennis Match Application");
		while(true) {
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
