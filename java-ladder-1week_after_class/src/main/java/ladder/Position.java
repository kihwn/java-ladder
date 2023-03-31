package ladder;

public class Position {  //Position = 위치
    private int position;

    private Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void goRight() {
        position += 1;
    }

    public void goLeft() {
        position -= 1;
    }


    //정적 팩토리 메서드
    public static Position createPosition(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public boolean isSmaller(int position) {
        return this.position < position;
    }

    public boolean isBigger(int position) {
        return this.position > position;
    }


    private static void validatePosition(int number) {
        if (!isPosition(number)) {
            throw new IllegalArgumentException("자연수는 1이상이어야 합니다.");
        }
    }

    private static boolean isPosition(int number) {
        return number >= 0;
    }
}
