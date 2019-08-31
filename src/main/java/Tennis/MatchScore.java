package Tennis;

import java.util.HashMap;

public class MatchScore {
    private HashMap<Player, GameScore> gameScore = new HashMap<>();
    private HashMap<Player, PointScore> pointScore = new HashMap<>();

    public MatchScore() {
        gameScore.put(Player.One, new GameScore());
        gameScore.put(Player.Two, new GameScore());
        pointScore.put(Player.One, new PointScore());
        pointScore.put(Player.Two, new PointScore());
    }

    public void pointWonBy(Player player) {
        pointScore.get(player).increment();
    }

    public String getScore() {
        return String.format("%d - %d, %d - %d",
                gameScore.get(Player.One).score,
                gameScore.get(Player.Two).score,
                pointScore.get(Player.One).getScore(),
                pointScore.get(Player.Two).getScore());
    }

}
