package ladder;

public class Node {

    private Direction direction;

    private Node(Direction direction) {
        this.direction = direction;
    }

    public void move(Position position) {
        if (isRight()) {
            position.goRight();
            return;
        }
        if (isLeft()) {
            position.goLeft();
        }
    }

    public boolean isRight() {
        return direction.equals(Direction.RIGHT);
    }

    public boolean isLeft() {
        return direction.equals(Direction.LEFT);
    }

    public static Node createRightNode() {
        return new Node(Direction.RIGHT);
    }

    public static Node createCenterNode() {
        return new Node(Direction.CENTER);
    }

    public static Node createLeftNode() {
        return new Node(Direction.LEFT);
    }

    public Direction getDirection() {
        return direction;
    }

}
