package Tennis;

public class PointScore {
    private int score;

    public int getScore() {
        return score;
    }

    public void increment() {
        switch(score) {
            case 0:
            case 15:
                score += 15;
                break;
            case 30:
                score += 10;
                break;
            default:
                break;
        }
    }
}
