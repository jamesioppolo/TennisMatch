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
        return String.format("%s, %s",
                getMatchScoreString(),
                getSetScoreString());
    }

    private String getMatchScoreString() {
        return String.format("%d - %d",
                gameScore.get(Player.One).score,
                gameScore.get(Player.Two).score);
    }

    private String getSetScoreString() {
        return isDeuce()
                ? "Deuce"
                : String.format("%d - %d",
                    pointScore.get(Player.One).getScore(),
                    pointScore.get(Player.Two).getScore());
    }

    private boolean isDeuce() {
        return pointScore.get(Player.One).getScore().equals(40) &&
               pointScore.get(Player.Two).getScore().equals(40);
    }

}
