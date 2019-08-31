package Tennis.Services;

public enum Player {
    One,
    Two;

    public static Player fromInteger(Integer x) {
        switch(x) {
            case 1:
                return Player.One;
            case 2:
                return Player.Two;
        }
        return null;
    }
}
