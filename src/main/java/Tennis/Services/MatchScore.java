package Tennis.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
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
        PointScore winningPlayerScore = pointScore.get(player);
        PointScore otherPlayerScore = pointScore.get(this.getOtherPlayerFor(player));
        if (this.willPointWinSet(winningPlayerScore)) {
            this.gameScore.get(player).increment();
            winningPlayerScore.reset();
            otherPlayerScore.reset();
        } else if (otherPlayerScore.hasAdvantage()) {
            otherPlayerScore.setAdvantage(false);
        } else if (this.isDeuce()) {
            winningPlayerScore.setAdvantage(true);
        } else {
            winningPlayerScore.increment();
        }
    }

    private Player getOtherPlayerFor(Player player) {
        return player.equals(Player.One)
                ? Player.Two
                : Player.One;
    }
    private boolean willPointWinSet(PointScore score) {
        return score.hasAdvantage() || (score.getScore().equals(40) && !this.isDeuce());
    }

    public String getScore() {
        return String.format("%s, %s",
                this.getMatchScoreString(),
                this.getSetScoreString());
    }

    public boolean isMatchInProgress() {
        return !(gameScore.get(Player.One).getScore().equals(6) ||
                gameScore.get(Player.Two).getScore().equals(6));
    }

    private String getMatchScoreString() {
        return String.format("%d - %d",
                gameScore.get(Player.One).getScore(),
                gameScore.get(Player.Two).getScore());
    }

    private String getSetScoreString() {
        if (!this.isMatchInProgress()){
            return this.getWinningPlayerString();
        } else if (pointScore.get(Player.One).hasAdvantage()) {
            return "Adv Player 1";
        } else if (pointScore.get(Player.Two).hasAdvantage())
        {
            return "Adv Player 2";
        } else if (this.isDeuce()) {
            return "Deuce";
        } else {
            return String.format("%d - %d",
                    pointScore.get(Player.One).getScore(),
                    pointScore.get(Player.Two).getScore());
        }
    }

    private String getWinningPlayerString() {
        String winningPlayerString = "";
        if (gameScore.get(Player.One).getScore().equals(6)) {
            winningPlayerString = "Player 1 wins!";
        } else if (gameScore.get(Player.Two).getScore().equals(6)) {
            winningPlayerString = "Player 2 wins!";
        }
        return winningPlayerString;
    }

    private boolean isDeuce() {
        return pointScore.get(Player.One).getScore().equals(40) &&
               pointScore.get(Player.Two).getScore().equals(40);
    }
}
