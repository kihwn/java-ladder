package ladder;

public enum Direction {
    LEFT(-1),RIGHT(1),CENTER(0);

    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}
